package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.PingLun;
import com.zoe.starfish_server.service.DianZanService;
import com.zoe.starfish_server.service.NewsService;
import com.zoe.starfish_server.service.PingLunService;
import com.zoe.starfish_server.utils.TimeUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论逻辑层
 */
@RestController
@RequestMapping("/pingLun/")
public class PingLunController {
    @Autowired
    PingLunService service;

    @Autowired
    NewsService newsService;

    @Autowired
    DianZanService dianZanService;

    /**
     * 提交评论
     *
     * @param servletRequest
     * @param pingLun
     * @return
     */
    @UserLoginToken
    @PostMapping("commit")
    public CommonResp commit(HttpServletRequest servletRequest, @RequestBody PingLun pingLun) {
        if (pingLun.getType() == null || pingLun.getContent() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        Integer type = pingLun.getType();
        if (type == 1 && pingLun.getNewsid() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        } else {
            //资讯的评论数增加
            newsService.pingLun(pingLun.getNewsid());
        }
        if (type == 2 && pingLun.getPinglunid() == null || pingLun.getUserid() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }

        pingLun.setCreatetime(TimeUtils.currTimeStamp());
        pingLun.setCreateby(TokenUtils.getUserId(servletRequest));
        pingLun.setDianzan(0L);

        return CommonResp.success(service.savePingLun(pingLun));
    }
}
