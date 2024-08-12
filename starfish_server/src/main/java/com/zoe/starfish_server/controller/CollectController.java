package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.common.resp.HouseResourceResp;
import com.zoe.starfish_server.common.resp.NewsResp;
import com.zoe.starfish_server.domain.Collect;
import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.service.*;
import com.zoe.starfish_server.utils.TimeUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 收藏逻辑层
 */
@RestController
@RequestMapping("/collect/")
public class CollectController {
    @Autowired
    CollectService service;

    @Autowired
    HouseResourceService houseResourceService;

    @Autowired
    NewsService newsService;

    //标签服务
    @Autowired
    HouseTagService tagService;

    //户型服务
    @Autowired
    HouseTypeService typeService;

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
        List<Collect> collects = service.collectList(userId, type);
        if (collects == null || collects.isEmpty()) {
            return CommonResp.success(new ArrayList<>());
        }
        if (type == 1) {
            //获取已收藏房源数据
            List<HouseResource> houseResources = houseResourceService.houseResources(false);
            if (houseResources == null || houseResources.isEmpty()) {
                return CommonResp.success(new ArrayList<>());
            }
            List<HouseResourceResp> respList = new ArrayList<>();
            for (Collect collect : collects) {
                for (HouseResource resource : houseResources) {
                    if (Objects.equals(collect.getHouseresid(), resource.getId())) {
                        respList.add(generateHouseResp(resource));
                    }
                }
            }
            return CommonResp.success(respList);
        } else if (type == 2) {
            //获取已收藏资讯数据
            List<NewsResp> respList = newsService.newsList(userId, null);
            List<NewsResp> collectNewsList = new ArrayList<>();
            for (NewsResp news : respList) {
                if (news.isCollected()) {
                    collectNewsList.add(news);
                }
            }
            return CommonResp.success(collectNewsList);
        }
        return CommonResp.success(new ArrayList<>());
    }

    private HouseResourceResp generateHouseResp(HouseResource resource) {
        HouseResourceResp resp = new HouseResourceResp();
        //房源名称
        resp.setTitle(resource.getName());
        //户型
        HouseType type = typeService.getType(resource.getHouseTypeId());
        if (type != null) {
            String typeName = type.getTypeName();
            //二级标题
            resp.setSubTitle(resource.getHouseDesc() + typeName);
        } else {
            //二级标题
            resp.setSubTitle(resource.getHouseDesc());
        }

        //标签列表
        List<HouseTag> houseTags = tagService.tagListForHouse(resource.getId());
        resp.setTagList(houseTags);

        //缩略图
        resp.setImage(resource.getImage());
        //租金
        resp.setRent(resource.getRent());
        //房源id
        resp.setId(resource.getId());

        return resp;
    }
}
