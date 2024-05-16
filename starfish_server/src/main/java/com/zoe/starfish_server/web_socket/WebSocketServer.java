package com.zoe.starfish_server.web_socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@Service
@ServerEndpoint("/api/websocket/{deviceId}")
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收deviceId
    private String deviceId = "";

    //心跳id，服务端每次心跳发给客户端，客户端需返回，如果不一致，视为掉线
    private String heartBeatId = "";
    //客户端是否返回心跳回执
    private boolean clientCallback = true;

    private Timer heartBeatTimer;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("deviceId") String deviceId) {
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        this.deviceId = deviceId;
        //在线数加1
        addOnlineCount();
        startTimer();
        try {
            sendMessage(WSResp.success(WSResp.WSRespCode.connectCode, "conn_success"));
            log.info("有新客户端开始监听:" + deviceId + ", 当前在线客户端数为:" + getOnlineCount());
        } catch (Exception e) {
            log.error("websocket IO Exception");
        }
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        heartBeatTimer.cancel();
        heartBeatTimer = null;
        //断开连接情况下，更新主板占用情况为释放
        log.info("释放的客户端deviceId为：" + deviceId);
        //这里写你 释放的时候，要处理的业务
        log.info("有一连接关闭！当前在线客户端数为：" + getOnlineCount());

    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @ Param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自客户端：" + deviceId + " 的信息:" + message);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WSResp wsResp = mapper.readValue(message, new TypeReference<WSResp<String>>(){});
            if (wsResp.getCode() == WSResp.WSRespCode.heartBeat) {
                if (wsResp.getBody().toString().equals(heartBeatId)) {
                    //心跳连接正常
                    log.info("客户端：" + deviceId + "，心跳连接正常");
                    clientCallback = true;
                } else {
                    clientCallback = false;
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }

    }
    public static <T> T JSONStringToObject(String str, TypeReference<T> valueTypeRef) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(str, valueTypeRef);
    }
    /**
     * @ Param session
     * @ Param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(WSResp message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String respJson = mapper.writeValueAsString(message);
        this.session.getBasicRemote().sendText(respJson);
    }

    /**
     * 群发自定义消息
     */
    public static boolean sendInfo(@PathParam("deviceId") String deviceId) throws IOException {
        log.info("推送消息到客户端：" + deviceId);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if (deviceId == null) {
                    return false;
                } else if (item.deviceId.equals(deviceId)) {
                    item.sendMessage(WSResp.success(WSResp.WSRespCode.uploadCode, deviceId));
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private void startTimer() {
        heartBeatTimer = new Timer();
        heartBeatTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    //客户端在线。保持心跳连接
                    if (clientCallback) {
                        heartBeatId = UUID.randomUUID().toString();
                        clientCallback = false;
                        sendMessage(WSResp.success(WSResp.WSRespCode.heartBeat, heartBeatId));
                    } else {
                        //客户端掉线了，断开连接
                        onClose();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 60000, 60000);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static CopyOnWriteArraySet<WebSocketServer> getWebSocketSet() {
        return webSocketSet;
    }
}
