package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.News;
import com.zoe.starfish_server.service.NewsService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.TimeUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 资讯逻辑层
 */
@RestController
@RequestMapping("/news/")
public class NewsController {
    @Autowired
    NewsService service;

    /**
     * 新增
     *
     * @param news
     * @return
     */
    @UserLoginToken
    @PostMapping("insertNews")
    public CommonResp insertNews(HttpServletRequest request, @RequestBody News news) {
        Long timeStamp = TimeUtils.currTimeStamp();
        news.setCreatetime(timeStamp);
        news.setOperationtime(timeStamp);
        Long userId = TokenUtils.getUserId(request);
        news.setCreateby(userId);
        news.setEditby(userId);
        news.setPinglun(0L);
        news.setDianzan(0L);
        //1=正常、-1=隐藏/下架
        news.setStatus(1);
        return CommonResp.success(service.insertNews(news));
    }

    /**
     * 设置下架
     *
     * @param newsId
     * @return
     */
    @UserLoginToken
    @PostMapping("disableNews")
    public CommonResp disableNews(@RequestParam Long newsId) {
        return CommonResp.success(service.disableNews(newsId));
    }

    /**
     * 根据类型获取资讯列表
     *
     * @return
     */
    @PassToken
    @PostMapping("getNewList")
    public CommonResp getNewList(@RequestBody News news) {
        if (news.getType() == null) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        //1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
        return CommonResp.success(service.newsList(news.getType()));
    }

    /**
     * 更新资讯内容
     *
     * @param news
     * @return
     */
    @UserLoginToken
    @PostMapping("updateNews")
    public CommonResp updateNews(HttpServletRequest request, @RequestBody News news) {
        Long userId = TokenUtils.getUserId(request);
        Long timeStamp = TimeUtils.currTimeStamp();
        news.setOperationtime(timeStamp);
        news.setEditby(userId);
        return CommonResp.success(service.updateNews(news));
    }
}
