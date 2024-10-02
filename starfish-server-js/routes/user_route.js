// routes/user_route.js
const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const uuid = require('../utils/uuid')
const multer = require('multer');
// 创建 multer 实例
const formMulter = multer();
const {
    CODE_ERROR,
    CODE_SUCCESS,
    PRIVATE_KEY,
    JWT_EXPIRED
} = require('../constants');
// const pool = require('../db/db');  // 引入数据库连接池
// const User = require('../models/user_model');
//控制器
const controller = require('../controller/user_controller')
const checkToken = require('../utils/token_valid')
const {token} = require("morgan");
//登录
router.post('/user/login', async (req, res) => {
    try {
        const response = await controller.UserController.getUserByInfo(req.body.name, req.body.password);
        console.log(response);
        const userId = response[0].dataValues.id;
        const userName = response[0].dataValues.name;
        const password = response[0].dataValues.password;
        // 登录成功，签发一个token并返回给前端
        const token = jwt.sign(
            // payload：签发的 token 里面要包含的一些数据。
            {userId, userName, password},
            // 私钥
            PRIVATE_KEY,
            // 设置过期时间
            {expiresIn: JWT_EXPIRED}
        )
        res.json({
            message: "success",
            code: 200,
            success: true,
            content: {
                id: response[0].dataValues.id,
                name: response[0].dataValues.name,
                password: response[0].dataValues.password,
                role: response[0].dataValues.role,
                create_time: response[0].dataValues.create_time,
                work_number: response[0].dataValues.work_number,
                pid: response[0].dataValues.pid,
                email: response[0].dataValues.email,
                address: response[0].dataValues.address,
                phone: response[0].dataValues.phone,
                gender: response[0].dataValues.gender,
                um_token: response[0].dataValues.um_token,
                tag: response[0].dataValues.tag,
                age: response[0].dataValues.age,
                open_msg: response[0].dataValues.open_msg,
                status: response[0].dataValues.status,
                token: token
            }
        });
    } catch (error) {
        //注册失败
        res.json({
            message: "注册失败",
            code: CODE_ERROR,
            success: false,
            content: false
        });
    }
});

// 创建新用户
router.post('/user/register', async (req, res) => {
    try {
        const {name, password, rePassword} = req.body;
        console.log("register name=" + name + ",password=" + password + ",rePassword=" + rePassword)
        if (password === rePassword) {
            console.log("register 密码校验通过")
            const userInfo = await controller.UserController.getUserByInfo(name, password);
            console.log(userInfo)
            if (userInfo.length === 0) {
                console.log("register 没有重复")
                const user = {
                    name: name,
                    password: password,
                    pid: uuid
                }
                console.log("register user=" + user)
                const callback = await controller.UserController.addUser(user)
                if (callback.dataValues.name === name) {
                    //注册成功
                    res.json({
                        message: "success",
                        code: 200,
                        success: true,
                        content: true
                    });
                } else {
                    //注册失败
                    res.json({
                        message: "注册失败",
                        code: CODE_ERROR,
                        success: false,
                        content: false
                    });
                }

            } else {
                //注册失败
                res.json({
                    message: "注册失败",
                    code: CODE_ERROR,
                    success: false,
                    content: false
                });
            }
        } else {
            //注册失败
            res.json({
                message: "注册失败",
                code: CODE_ERROR,
                success: false,
                content: false
            });
        }
    } catch (error) {
        //注册失败
        res.json({
            message: "注册失败",
            code: CODE_ERROR,
            success: false,
            content: false
        });
    }
});

// 获取所有用户
router.post('/user/userList', async (req, res) => {
    const response = await controller.UserController.getAllUsers();
    res.json({
        message: "success",
        code: 200,
        success: true,
        content: response
    });
});

//绑定UMToken到用户
router.post('/user/bindToken', formMulter.none(), async (req, res) => {
    //拿到token
    const token = checkToken.decode(req.header("token"))
    //查到用户
    const userInfo = await controller.UserController.getUserById(token.userId);
    //绑定UMToken到用户
    const callback = await controller.UserController.setUmToken(userInfo[0].dataValues.id, req.body.umToken.toString())
    res.json({
        message: "success",
        code: 200,
        success: true,
        content: callback
    });
});

//是否开启消息
router.post('/user/openMsg', formMulter.none(), async (req, res) => {
    //拿到token
    const token = checkToken.decode(req.header("token"))
    //查到用户
    const userInfo = await controller.UserController.getUserById(token.userId);
    //openFlag = 0 关闭，1 开启
    const openFlag = req.body.openFlag;
    const callback = await controller.UserController.setMsgOpen(userInfo[0].dataValues.id, openFlag)
    res.json({
        message: "success",
        code: 200,
        success: true,
        content: callback
    });
});
module.exports = router;
