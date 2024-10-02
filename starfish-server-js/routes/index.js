// routes/index.js
const express = require('express');
const router = express.Router();

// 引入各个模块的路由
const userRoute = require('./user_route');
const bannerRoute = require('./banner_route');
const newsRoute = require('./news_route');
const {CODE_TOKEN_EXPIRED} = require("../constants");
const {jwtAuth} = require("../utils/token_valid");

router.use(jwtAuth); // 注入认证模块
// 使用不同模块的路由
router.use('/auth', userRoute);   // /api/users
router.use('/banner', bannerRoute); // /api/banners
router.use('/new', newsRoute);    // /api/news

// 自定义统一异常处理中间件，需要放在代码最后
router.use((err, req, res, next) => {
    // 自定义用户认证失败的错误返回
    console.log('err===', err);
    if (err && err.name === 'UnauthorizedError') {
        // const { status = 401, message } = err;
        // 抛出401异常
        res.json({
            message: "token失效",
            code: CODE_TOKEN_EXPIRED,
            success: false,
            content: false
        });
    } else {
        const { output } = err || {};
        // 错误码和错误信息
        const errCode = (output && output.statusCode) || 500;
        const errMsg = (output && output.payload && output.payload.error) || err.message;
        res.json({
            message: errMsg,
            code: errCode,
            success: false,
            content: false
        });
    }
})

module.exports = router;
