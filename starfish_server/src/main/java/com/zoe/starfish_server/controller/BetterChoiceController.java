package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.BetterChoice;
import com.zoe.starfish_server.service.BetterChoiceService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 优选数据控制器
 */
@RestController
@RequestMapping("/betterChoice")
public class BetterChoiceController {

    @Autowired
    BetterChoiceService service;

    @PassToken
    @PostMapping("/choiceList")
    public CommonResp choiceList() {
        return CommonResp.success(service.choiceList());
    }

    @UserLoginToken
    @PostMapping("/insertChoice")
    public CommonResp insertChoice(@RequestBody BetterChoice choice) {
        int code = service.insertChoice(choice);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code == 1);
    }

    @UserLoginToken
    @PostMapping("/deleteChoice")
    public CommonResp deleteChoice(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteChoice(id) == 1);
    }

    @UserLoginToken
    @PostMapping("/updateChoice")
    public CommonResp updateChoice(@RequestBody BetterChoice choice) {
        return CommonResp.success(service.updateChoice(choice) == 1);
    }
}
