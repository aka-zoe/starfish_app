package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.Collect;
import com.zoe.starfish_server.domain.News;
import com.zoe.starfish_server.service.CollectService;
import com.zoe.starfish_server.service.NewsService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.TimeUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 收藏逻辑层
 */
@RestController
@RequestMapping("/collect/")
public class CollectController {
    @Autowired
    CollectService service;

    /**
     * 新增
     *
     * @param collect
     * @return
     */
    @UserLoginToken
    @PostMapping("insertCollect")
    public CommonResp insertCollect(HttpServletRequest request, @RequestBody Collect collect) {
        Long timeStamp = TimeUtils.currTimeStamp();
        Long userId = TokenUtils.getUserId(request);
        collect.setCollecttime(timeStamp);
        collect.setUserid(userId);
        return CommonResp.success(service.insertCollect(collect));
    }


    /**
     * 取消收藏
     *
     * @param request
     * @param houseResId 房源id
     * @param newsId     资讯id
     * @param type       收藏类型
     * @param id         收藏id
     * @return
     */
    @UserLoginToken
    @PostMapping("cancelCollect")
    public CommonResp cancelCollect(HttpServletRequest request, @RequestParam(required = false) Long houseResId, @RequestParam(required = false) Long newsId, @RequestParam Integer type, @RequestParam(required = false) Long id) {
        Long userId = TokenUtils.getUserId(request);
        return CommonResp.success(service.cancelCollect(userId, type, houseResId, newsId, id));
    }

    /**
     * 根据类型获取收藏列表
     *
     * @param request
     * @param type
     * @return
     */
    @UserLoginToken
    @PostMapping("collectList")
    public CommonResp collectList(HttpServletRequest request, @RequestParam Integer type) {
        if (type == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        Long userId = TokenUtils.getUserId(request);
        //收藏分类：1=房源，2=资讯
        return CommonResp.success(service.collectList(userId, type));
    }

}
