package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.service.HouseTagService;
import com.zoe.starfish_server.service.HouseTypeService;
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

    @GetMapping("/houseTypeList")
    public CommonResp houseTypeList() {
        return CommonResp.successRsp(service.houseTypeList());
    }


    @GetMapping("/getType")
    public CommonResp getType(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.getType(id));
    }

    @PostMapping("/insertHouseType")
    public CommonResp insertHouseType(@RequestBody HouseType houseType) {
        int code = service.insertHouseType(houseType);
        if (code == -1) {
            return CommonResp.errorRsp("数据已存在", code);
        }
        return CommonResp.successRsp(code);
    }

    @DeleteMapping("/deleteHouseType")
    public CommonResp deleteHouseType(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.deleteHouseType(id));
    }

    @PostMapping("/updateHouseType")
    public CommonResp updateHouseType(@RequestBody HouseType houseType) {
        return CommonResp.successRsp(service.updateHouseType(houseType));
    }
}
