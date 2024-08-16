
package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.domain.Message;
import com.zoe.starfish_server.service.BannerService;
import com.zoe.starfish_server.service.MessageService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 消息通知控制器
 */
@RestController
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    MessageService service;

    /**
     * 获取当前用户的消息，根据type
     *
     * @param request
     * @param type
     * @return
     */
    @UserLoginToken
    @PostMapping(value = "getMessages")
    public CommonResp getMessages(HttpServletRequest request, @RequestParam(name = "type",required = false) Integer type) {
        return CommonResp.success(service.getMessages(TokenUtils.getUserId(request), type));
    }


    /**
     * 添加消息
     *
     * @param message
     * @return
     */
    @UserLoginToken
    @PostMapping("addMessage")
    public CommonResp addMessage(@RequestBody Message message) {
        message.setCreatetime(System.currentTimeMillis());
        message.setStatus(1);
        return CommonResp.success(service.addMessage(message));
    }

    /**
     * 删除消息
     *
     * @param id
     * @return
     */
    @UserLoginToken
    @PostMapping("deleteMessage")
    public CommonResp deleteMessage(@RequestParam(value = "id") Long id) {
        return CommonResp.success(service.deleteMessage(id) == 1);
    }

    /**
     * 设置消息已读
     *
     * @param id
     * @return
     */
    @UserLoginToken
    @PostMapping("setReadMessage")
    public CommonResp setReadMessage(@RequestParam(value = "id") Long id) {
        Message message = service.getMessage(id);
        if (message != null) {
            message.setStatus(2);
            return CommonResp.success(service.updateMessage(message));
        } else {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
    }

    /**
     * 设置消息全部已读
     *
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("setAllMessageRead")
    public CommonResp setAllMessageRead(HttpServletRequest request) {
        List<Message> messages = service.getMessages(TokenUtils.getUserId(request), 1);
        for (Message message : messages) {
            message.setStatus(2);
            service.updateMessage(message);
        }
        return CommonResp.success(true);
    }

}
