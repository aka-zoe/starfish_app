package com.zoe.starfish_server.push;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoe.starfish_server.service.AppConfigService;
import com.zoe.starfish_server.utils.OkHttpUtils;
import com.zoe.starfish_server.utils.StringUtils;
import okhttp3.Call;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PushInstance {

    private final static PushInstance instance = new PushInstance();

    public static PushInstance getInstance() {
        return instance;
    }

    public void init(String masterSecret, String appKey, String host) {
        PushConfig.APPMasterSecret = masterSecret;
        PushConfig.APPKey = appKey;
        PushConfig.UMHost = host;
    }

    public boolean notInit() {
        return StringUtils.isEmpty(PushConfig.APPMasterSecret)
                || StringUtils.isEmpty(PushConfig.APPKey)
                || StringUtils.isEmpty(PushConfig.UMHost);
    }

    public Boolean pushMessage(String deviceToken, Map<String, String> customMap) {
        NotificationRequest request = NotificationRequest.buildMessage(deviceToken, customMap);
        return push(request);
    }

    public Boolean pushNotification(String deviceToken, Map<String, String> paramMap, Map<String, String> extraMap) {
        NotificationRequest request = NotificationRequest.buildNotification(deviceToken, paramMap, extraMap);
        return push(request);
    }

    public Boolean push(NotificationRequest request) {
        if (notInit()) {
            throw new RuntimeException("当前推送配置信息没有初始化！");
        }


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonParam = "";

        try {
            jsonParam = mapper.writeValueAsString(request);
        } catch (JsonProcessingException exception) {
            jsonParam = "";
        }
        String sign = PushConfig.generateSign(PushConfig.getRequestUrl("/api/send"), jsonParam);
        OkHttpUtils.getInstance().postFroJson(PushConfig.getRequestUrl("/api/send?sign=" + sign), jsonParam, new OkHttpUtils.Callback() {
            @Override
            public void onSuccess(Call call, Object data) {
                try {
                    Response execute = call.execute();
                    String string = execute.body().string();
                    System.out.println("deviceToken= " + request.getDevice_tokens() + " ，发送推送返回：" + string);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onError(Call call, int code, String errorMsg) {
                System.out.println("onError= " + errorMsg);
            }

            @Override
            public void onSuccess(Call call, String response) {
                System.out.println("response= " + response);
            }
        });

        return true;
    }

    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("title", "测试推送消息标题");
        paramMap.put("text", "测试推送消息内容");
        paramMap.put("ticker", "测试推送消息内容2");
        Map<String, String> extraMap = new HashMap<>();
        PushInstance.getInstance().pushMessage("AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK",paramMap);
        PushInstance.getInstance().pushNotification("AhBrZWFttoYP5WnyMLwa9nd9IBvjvbo7YQNDELZyLJY3", paramMap, extraMap);

    }
}
