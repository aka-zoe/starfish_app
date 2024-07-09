package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.service.HouseTagService;
import com.zoe.starfish_server.service.HouseTypeService;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 户型控制器
 */
@RestController
@RequestMapping("/houseType")
public class HouseTypeController {
    @Autowired
    HouseTypeService service;

    @UserLoginToken
    @PostMapping("/houseTypeList")
    public CommonResp houseTypeList() {
        return CommonResp.success(service.houseTypeList());
    }

    @UserLoginToken
    @PostMapping("/getType")
    public CommonResp getType(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.getType(id));
    }

    @UserLoginToken
    @PostMapping("/insertHouseType")
    public CommonResp insertHouseType(@RequestBody HouseType houseType) {
        int code = service.insertHouseType(houseType);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code);
    }

    @UserLoginToken
    @PostMapping("/deleteHouseType")
    public CommonResp deleteHouseType(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteHouseType(id));
    }

    @UserLoginToken
    @PostMapping("/updateHouseType")
    public CommonResp updateHouseType(@RequestBody HouseType houseType) {
        return CommonResp.success(service.updateHouseType(houseType));
    }
}
