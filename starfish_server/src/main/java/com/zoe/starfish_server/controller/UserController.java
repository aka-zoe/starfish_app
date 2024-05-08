package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.req.ReqLogin;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zoe.starfish_server.utils.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResp login(@RequestBody ReqLogin reqLogin) {
        if (reqLogin != null && StringUtils.isNotEmpty(reqLogin.getName()) && StringUtils.isNotEmpty(reqLogin.getPassword())) {
            List<User> userList = userService.getUserList();
            for (User user : userList) {
                if (user.getName().equals(reqLogin.getName()) && user.getPassword().equals(reqLogin.getPassword())) {
                    User u = userService.getUser(user.getId());
                    return CommonResp.successRsp(u);
                }
            }
        }
        return CommonResp.errorRsp();
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("/userList")
    public CommonResp userList() {
        return CommonResp.successRsp(userService.getUserList());
    }

    /**
     * 获取用户 by id
     *
     * @param id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public CommonResp getUser(@PathVariable("id") Long id) {
        return CommonResp.successRsp(userService.getUser(id));
    }
}
