package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.HouseImg;
import com.zoe.starfish_server.service.HouseImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 房源图片控制器
 */
@RestController
@RequestMapping("/houseImg")
public class HouseImgController {
    @Autowired
    HouseImgService service;

    @GetMapping("/getImage")
    public CommonResp getImage(@RequestParam(value = "id", required = true) Long id){
        return CommonResp.success(service.getImage(id));
    }


    @GetMapping("/houseImgList")
    public CommonResp houseImgList() {
        return CommonResp.success(service.houseImgList());
    }

    @GetMapping("/imgForHouse")
    public CommonResp imgForHouse(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.imgForHouse(id));
    }

    @PostMapping("/insertHouseImg")
    public CommonResp insertHouseImg(@RequestBody HouseImg houseImg) {
        int code = service.insertHouseImg(houseImg);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code);
    }

    @DeleteMapping("/deleteHouseImg")
    public CommonResp deleteHouseImg(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteHouseImg(id));
    }

    @PostMapping("/updateHouseImg")
    public CommonResp updateHouseImg(@RequestBody HouseImg houseImg) {
        return CommonResp.success(service.updateHouseImg(houseImg));
    }
}
