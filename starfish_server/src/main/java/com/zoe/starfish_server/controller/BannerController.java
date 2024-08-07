package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.service.BannerService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * banner推广控制器
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService service;

    @PassToken
    @PostMapping(value = "/bannerList")
    public CommonResp bannerList() {
        return CommonResp.success(service.bannerList());
    }


    @UserLoginToken
    @PostMapping("/insertBanner")
    public CommonResp insertBanner(@RequestBody Banner banner) {
        int code = service.insertBanner(banner);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(true);
    }

    @UserLoginToken
    @PostMapping("/deleteBanner")
    public CommonResp deleteBanner(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteBanner(id) == 1);
    }

    @UserLoginToken
    @PostMapping("/updateBanner")
    public CommonResp updateBanner(@RequestBody Banner banner) {
        return CommonResp.success(service.updateBanner(banner) == 1);
    }
}
