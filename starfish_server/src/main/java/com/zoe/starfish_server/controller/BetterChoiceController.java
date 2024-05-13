package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.BetterChoice;
import com.zoe.starfish_server.service.BetterChoiceService;
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

    @GetMapping("/choiceList")
    public CommonResp choiceList() {
        return CommonResp.successRsp(service.choiceList());
    }

    @PostMapping("/insertChoice")
    public CommonResp insertChoice(@RequestBody BetterChoice choice) {
        int code = service.insertChoice(choice);
        if (code == -1) {
            return CommonResp.errorRsp("数据已存在", code);
        }
        return CommonResp.successRsp(code);
    }

    @DeleteMapping("/deleteChoice")
    public CommonResp deleteChoice(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.deleteChoice(id));
    }

    @PostMapping("/updateChoice")
    public CommonResp updateChoice(@RequestBody BetterChoice choice) {
        return CommonResp.successRsp(service.updateChoice(choice));
    }
}
