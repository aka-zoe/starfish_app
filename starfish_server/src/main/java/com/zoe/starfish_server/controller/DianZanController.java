package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.DianZan;
import com.zoe.starfish_server.service.DianZanService;
import com.zoe.starfish_server.service.NewsService;
import com.zoe.starfish_server.service.PingLunService;
import com.zoe.starfish_server.utils.TimeUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 资讯、评论的点赞逻辑
 */
@RequestMapping("/dianZan/")
@RestController
public class DianZanController {
    @Autowired
    DianZanService service;

    @Autowired
    NewsService newsService;

    @Autowired
    PingLunService pingLunService;

    @UserLoginToken
    @PostMapping("set")
    public CommonResp dianZan(HttpServletRequest request, @RequestBody DianZan dianZan) {
        if (dianZan == null || dianZan.getType() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        Integer type = dianZan.getType();
        Long currTimeStamp = TimeUtils.currTimeStamp();
        Long userId = TokenUtils.getUserId(request);
        dianZan.setCreatetime(currTimeStamp);
        dianZan.setCreateby(userId);
        //1=资讯、2=评论
        if (type == 1) {
            if (dianZan.getNewsid() == null) {
                return CommonResp.error(RespCodeEnum.PARAMERR);
            }
            //资讯点赞数量增加
            newsService.dianZan(dianZan.getNewsid(), false);
        } else if (type == 2) {
            if (dianZan.getPinglunid() == null) {
                return CommonResp.error(RespCodeEnum.PARAMERR);
            }
            //评论点赞数量增加
            pingLunService.dianZan(dianZan.getPinglunid(), false);
        }

        //保存点赞数据
        return CommonResp.success(service.saveDianZan(dianZan));
    }

    /**
     * 取消点赞
     *
     * @param dianZan
     * @return
     */
    @UserLoginToken
    @PostMapping("cancel")
    public CommonResp cancel(@RequestBody DianZan dianZan) {
        if (dianZan == null || dianZan.getType() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        Integer type = dianZan.getType();
        //1=资讯、2=评论
        if (type == 1) {
            //资讯表，点赞取消
            newsService.dianZan(dianZan.getNewsid(), true);
            //点赞表，删除点赞数据
        } else if (type == 2) {
            //评论表，点赞取消
            pingLunService.dianZan(dianZan.getPinglunid(), true);
        }
        return CommonResp.success(service.cancel(dianZan.getType(), dianZan.getNewsid(), dianZan.getPinglunid()));

    }
}
