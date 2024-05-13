package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.req.ReqLogin;
import com.zoe.starfish_server.common.req.ReqRegister;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.service.UserService;
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

    @PostMapping("/login")
    public CommonResp login(@RequestBody ReqLogin reqLogin) {
        String name = reqLogin.getName();
        String password = reqLogin.getPassword();
        List<User> users = userService.checkExistUser(name, password);

        //没有此用户或者密码错误
        if(users==null || users.isEmpty()){
            return CommonResp.errorRsp("没有此用户或者密码错误",-888);
        }

        //返回当前用户信息
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return CommonResp.successRsp(user);
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
        if (!userService.checkExistUser(name,password).isEmpty()) {
            return CommonResp.errorRsp("name is already exist！", -999);
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        //插入用户
        return CommonResp.successRsp(userService.insertUser(user));
    }
}
