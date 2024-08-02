package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.AppConfig;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.push.PushInstance;
import com.zoe.starfish_server.service.AppConfigService;
import com.zoe.starfish_server.service.UserService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.StringUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 绑定当前项目用到的第三方配置信息
 * 当前只有友盟推送的配置信息
 */
@RestController
@RequestMapping("/appConfig")
public class AppConfigController {
    @Autowired
    AppConfigService service;

    @Autowired
    UserService userService;

    /**
     * 查看配置信息
     *
     * @return
     */
    @PassToken
    @PostMapping(value = "/getConfig")
    public CommonResp getConfig() {
        return CommonResp.success(service.getConfig());
    }


    /**
     * 修改配置信息，新信息会覆盖已有的
     *
     * @param config
     * @return
     */
    @PassToken
    @PostMapping("/insertOrUpdateBanner")
    public CommonResp insertOrUpdateBanner(@RequestBody AppConfig config) {
        return CommonResp.success(service.insertOrUpdateBanner(config));
    }

    /**
     * 测试推送
     * @param paramMap
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/testPush")
    public CommonResp testPush(@RequestBody Map<String, String> paramMap, HttpServletRequest request) {
        Long userId = TokenUtils.getUserId(request);
        User user = userService.getUser(userId);
        if (user == null || StringUtils.isEmpty(user.getUmToken())) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }

        boolean notInit = PushInstance.getInstance().notInit();
        if (notInit) {
            AppConfig config = service.getConfig();
            if (config == null) {
                return CommonResp.error(RespCodeEnum.SYSERR);
            }
            PushInstance.getInstance().init(config.getUmAppMasterSecret(), config.getUmAppKey(), config.getUmHost());
        }
        Boolean success = PushInstance.getInstance().pushNotification(user.getUmToken(), paramMap, null);
        return CommonResp.success(success);
    }
}
