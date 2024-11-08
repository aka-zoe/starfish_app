package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.service.HouseTagService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.UserLoginToken;
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

    @PassToken
    @PostMapping("/allTagList")
    public CommonResp allTagList() {
        return CommonResp.success(service.allTagList());
    }

    @PassToken
    @PostMapping("/tagListForHouse")
    public CommonResp tagListForHouse(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.tagListForHouse(id));
    }

    @UserLoginToken
    @PostMapping("/insertHouseTag")
    public CommonResp insertHouseTag(@RequestBody HouseTag houseTag) {
        int code = service.insertHouseTag(houseTag);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code);
    }

    @UserLoginToken
    @PostMapping("/deleteHouseTag")
    public CommonResp deleteHouseTag(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteHouseTag(id));
    }

    @UserLoginToken
    @PostMapping("/updateHouseTag")
    public CommonResp updateHouseTag(@RequestBody HouseTag houseTag) {
        return CommonResp.success(service.updateHouseTag(houseTag));
    }
}
