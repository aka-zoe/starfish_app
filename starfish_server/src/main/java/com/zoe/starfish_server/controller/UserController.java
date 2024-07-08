package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.req.ReqLogin;
import com.zoe.starfish_server.common.req.ReqRegister;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.service.UserService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.TokenUtils;
import com.zoe.starfish_server.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PassToken
    @PostMapping("/login")
    public CommonResp login(@RequestBody ReqLogin reqLogin) {
        String name = reqLogin.getName();
        String password = reqLogin.getPassword();
        List<User> users = userService.checkExistUser(name, password);

        //没有此用户或者密码错误
        if (users == null || users.isEmpty()) {
            return CommonResp.error(RespCodeEnum.AUTHERROR);
        }

        //返回当前用户信息
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                String token = TokenUtils.token(user.getName(), user.getId());
                user.setToken(token);
                return CommonResp.success(user);
            }
        }
        return CommonResp.error(RespCodeEnum.FAIL);
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @UserLoginToken
    @GetMapping("/userList")
    public CommonResp userList() {
        return CommonResp.success(userService.getUserList());
    }

    /**
     * 获取用户 by id
     *
     * @param id
     * @return
     */
    @UserLoginToken
    @GetMapping("/getUser/{id}")
    public CommonResp getUser(@PathVariable("id") Long id) {
        return CommonResp.success(userService.getUser(id));
    }

    /**
     * 用户注册
     *
     * @param reqRegister
     * @return
     */
    @PostMapping("/register")
    public CommonResp register(@RequestBody ReqRegister reqRegister) {

        String name = reqRegister.getName();
        String password = reqRegister.getPassword();
        //不能存在相同用户名
        if (!userService.checkExistUser(name, password).isEmpty()) {
            return CommonResp.error(RespCodeEnum.SAMEUSER);
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        //插入用户
        return CommonResp.success(userService.insertUser(user));
    }
}
