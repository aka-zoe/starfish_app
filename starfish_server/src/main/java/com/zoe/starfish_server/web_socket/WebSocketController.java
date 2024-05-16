package com.zoe.starfish_server.web_socket;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("web_socket_system")
@RequestMapping("/api/socket")
public class WebSocketController {

    /**
     * Web要求APP上传日志
     * 服务端通过长链接通知APP上传
     *
     * @param deviceId
     * @return
     */
    @ResponseBody
    @PostMapping("/sendUploadLogFileCmd")
    public CommonResp sendUploadLogFileCmd(@RequestParam(value = "deviceId", required = true) String deviceId) {
        try {
            //发送上传日志指令
            boolean success = WebSocketServer.sendInfo(deviceId);
            if (success) {
                return CommonResp.success(true);
            } else {
                return CommonResp.error(RespCodeEnum.SOCKETSENDERR);
            }
        } catch (Exception e) {
            return CommonResp.errorMsg(RespCodeEnum.SOCKETSENDERR, e.getMessage());
        }
    }

}
