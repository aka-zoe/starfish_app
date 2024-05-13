package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.service.HouseTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 房源标签控制器
 */
@RestController
@RequestMapping("/houseTag")
public class HouseTagController {
    @Autowired
    HouseTagService service;

    @GetMapping("/allTagList")
    public CommonResp allTagList() {
        return CommonResp.successRsp(service.allTagList());
    }

    @GetMapping("/tagListForHouse")
    public CommonResp tagListForHouse(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.tagListForHouse(id));
    }

    @PostMapping("/insertHouseTag")
    public CommonResp insertHouseTag(@RequestBody HouseTag houseTag) {
        int code = service.insertHouseTag(houseTag);
        if (code == -1) {
            return CommonResp.errorRsp("数据已存在", code);
        }
        return CommonResp.successRsp(code);
    }

    @DeleteMapping("/deleteHouseTag")
    public CommonResp deleteHouseTag(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.deleteHouseTag(id));
    }

    @PostMapping("/updateHouseTag")
    public CommonResp updateHouseTag(@RequestBody HouseTag houseTag) {
        return CommonResp.successRsp(service.updateHouseTag(houseTag));
    }
}
