package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.LivingArea;
import com.zoe.starfish_server.service.LivingAreaService;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 房源图片控制器
 */
@RestController
@RequestMapping("/livingArea")
public class LivingAreaController {
    @Autowired
    LivingAreaService service;

    @UserLoginToken
    @GetMapping("/areaList")
    public CommonResp areaList() {
        return CommonResp.success(service.areaList());
    }

    @UserLoginToken
    @GetMapping("/getArea")
    public CommonResp getArea(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.getArea(id));
    }

    @UserLoginToken
    @PostMapping("/insertLivingArea")
    public CommonResp insertLivingArea(@RequestBody LivingArea livingArea) {
        int code = service.insertLivingArea(livingArea);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code);
    }

    @UserLoginToken
    @DeleteMapping("/deleteLivingArea")
    public CommonResp deleteLivingArea(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteLivingArea(id));
    }

    @UserLoginToken
    @PostMapping("/updateLivingArea")
    public CommonResp updateLivingArea(@RequestBody LivingArea livingArea) {
        return CommonResp.success(service.updateLivingArea(livingArea));
    }
}
