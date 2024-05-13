package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.service.BannerService;
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

    @GetMapping("/bannerList")
    public CommonResp bannerList() {
        return CommonResp.successRsp(service.bannerList());
    }

    @PostMapping("/insertBanner")
    public CommonResp insertBanner(@RequestBody Banner banner) {
        int code = service.insertBanner(banner);
        if (code == -1) {
            return CommonResp.errorRsp("数据已存在", code);
        }
        return CommonResp.successRsp(code);
    }

    @DeleteMapping("/deleteBanner")
    public CommonResp deleteBanner(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.deleteBanner(id));
    }

    @PostMapping("/updateBanner")
    public CommonResp updateBanner(@RequestBody Banner banner) {
        return CommonResp.successRsp(service.updateBanner(banner));
    }
}