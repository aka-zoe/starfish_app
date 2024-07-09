package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.BookedHouse;
import com.zoe.starfish_server.service.BookedHouseService;
import com.zoe.starfish_server.utils.StringUtils;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 房源预约
 */
@RestController
@RequestMapping("/bookedHouse/")
public class BookedHouseController {
    @Autowired
    BookedHouseService service;

    @UserLoginToken
    @PostMapping("saveBookedHouse")
    public CommonResp saveBookedHouse(HttpServletRequest request, @RequestBody BookedHouse bookedHouse) {
        if (bookedHouse.getBookeduserid() == null ||
                bookedHouse.getHouseresid() == null ||
                bookedHouse.getBookedtime() == null ||
                StringUtils.isEmpty(bookedHouse.getUserphone()) ||
                StringUtils.isEmpty(bookedHouse.getUsername())) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }

        bookedHouse.setUserid(TokenUtils.getUserId(request));
        bookedHouse.setStatus(1);
        return CommonResp.success(service.saveBookedHouse(bookedHouse));
    }

    /**
     * 当前用户的预约记录
     *
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("bookedHouseList")
    public CommonResp bookedHouseList(HttpServletRequest request) {
        return CommonResp.success(service.getBookedHouseList(TokenUtils.getUserId(request)));
    }
}
