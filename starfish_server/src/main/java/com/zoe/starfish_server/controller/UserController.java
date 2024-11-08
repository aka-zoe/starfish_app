package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.req.ReqLogin;
import com.zoe.starfish_server.common.req.ReqRegister;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.service.UserService;
import com.zoe.starfish_server.tencent_im.IMInstance;
import com.zoe.starfish_server.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
                String token = TokenUtils.token(user.getName(), user.getPassword(), user.getId());
                user.setToken(token);
                //登录后默认调一次添加IM用户接口
                if (user.getPid() != null) {
                    IMInstance.getInstance().importAccount(user.getPid(), user.getName(), "");
                }
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
    @PostMapping("/userList")
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
    @PostMapping("/getUser/{id}")
    public CommonResp getUser(@PathVariable("id") Long id) {
        return CommonResp.success(userService.getUser(id));
    }

    /**
     * 用户注册
     *
     * @param reqRegister
     * @return
     */
    @PassToken
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
        String pid = PIDUtils.generatePID();
        user.setPid(pid);
        //插入用户
        boolean b = userService.insertUser(user);
        if (b) {
            //注册为IM账户
            IMInstance.getInstance().importAccount(pid, name, "");
        }
        return CommonResp.success(b);
    }

    /**
     * 绑定友盟token信息
     *
     * @param servletRequest
     * @param umToken
     * @param tag
     * @return
     */
    @UserLoginToken
    @PostMapping("/bindToken")
    public CommonResp bindToken(HttpServletRequest servletRequest,
                                @RequestParam("umToken") String umToken,
                                @RequestParam("tag") String tag) {
        Long userId = TokenUtils.getUserId(servletRequest);
        if (userId == null || StringUtils.isEmpty(umToken)) {
            return CommonResp.error(RespCodeEnum.PARAMERR);
        }
        User user = userService.getUser(userId);
        user.setUmToken(umToken);
        if (!StringUtils.isEmpty(tag)) {
            if (StringUtils.isNotEmpty(user.getTag())) {
                user.setTag(user.getTag() + "|" + tag);
            } else {
                user.setTag(tag);
            }
        }
        return CommonResp.success(userService.updateUser(user) == 1);

    }

    /**
     * 是否开启消息
     *
     * @param request
     * @param openFlag
     * @return
     */
    @UserLoginToken
    @PostMapping("/openMsg")
    public CommonResp openMsg(HttpServletRequest request, @RequestParam("openFlag") Boolean openFlag) {
        User user = userService.getUser(TokenUtils.getUserId(request));
        if (user != null) {
            user.setOpenMsg(openFlag ? 1 : 0);
        }
        int i = userService.updateUser(user);
        return CommonResp.success(i == 1);
    }
}
