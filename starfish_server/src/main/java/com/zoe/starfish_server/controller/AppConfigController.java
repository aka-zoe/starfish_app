package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.AppInfoResp;
import com.zoe.starfish_server.common.resp.BookedListResp;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.AppConfig;
import com.zoe.starfish_server.domain.Collect;
import com.zoe.starfish_server.domain.Message;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.push.PushInstance;
import com.zoe.starfish_server.service.*;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.StringUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

    @Autowired
    BookedHouseService bookedHouseService;

    @Autowired
    CollectService collectService;

    @Autowired
    MessageService messageService;

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
     *
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
        //保存消息
        Message message = new Message();
        message.setUserid(userId);
        message.setCreatetime(System.currentTimeMillis());
        // 必填，通知标题
        message.setTitle(paramMap.get("title"));
        // 必填，通知文字描述
        message.setSubtitle(paramMap.get("text"));
        //可选, 通知栏提示文字
        message.setContent(paramMap.get("ticker"));
        message.setStatus(1);
        messageService.addMessage(message);
        return CommonResp.success(success);
    }

    /**
     * 获取当前用户相关的APP信息
     *
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/getAppInfo")
    public CommonResp getAppInfo(HttpServletRequest request) {
        Long userId = TokenUtils.getUserId(request);
        AppInfoResp appInfoResp = new AppInfoResp();
        if (userId == null) {
            return CommonResp.success(appInfoResp);
        }
        List<BookedListResp> bookedHouseList = bookedHouseService.getBookedHouseList(userId);
        //状态（1=待处理、2=超时未处理、3=已处理、4=已关闭）
        int bookedCount = 0;
        for (BookedListResp booked : bookedHouseList) {
            Integer status = booked.getStatus();
            if (status != null && status == 1 | status == 2) {
                bookedCount++;
            }
        }
        appInfoResp.setBookedCount(bookedCount);
        List<Collect> collectsHouse = collectService.collectList(userId, 1);
        List<Collect> collectsNews = collectService.collectList(userId, 2);
        if (collectsHouse != null && !collectsHouse.isEmpty()) {
            appInfoResp.setCollectHouseCount(collectsHouse.size());
        } else {
            appInfoResp.setCollectHouseCount(0);
        }
        if (collectsNews != null && !collectsNews.isEmpty()) {
            appInfoResp.setCollectNewsCount(collectsNews.size());
        } else {
            appInfoResp.setCollectNewsCount(0);
        }

        appInfoResp.setUnreadMsgCount(0);
        User user = userService.getUser(userId);
        if (user != null) {
            appInfoResp.setOpenMsg(user.getOpenMsg() == 1);
        } else {
            appInfoResp.setOpenMsg(false);
        }

        return CommonResp.success(appInfoResp);
    }
}
