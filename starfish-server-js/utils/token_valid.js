/**
 * jwt-token验证和解析函数
 */

const jwt = require('jsonwebtoken'); // 引入验证jsonwebtoken模块
const expressJwt = require('express-jwt'); // 引入express-jwt模块
const {PRIVATE_KEY} = require('../constants'); // 引入自定义的jwt密钥

// 验证token是否过期
const jwtAuth = expressJwt({
    // 设置密钥
    secret: PRIVATE_KEY,
    // 设置为true表示校验，false表示不校验
    credentialsRequired: true,
    // 自定义获取token的函数
    getToken: (req) => {
        if (req.header("token")) {
            return req.header("token");
        } else {
            return "";
        }
    }
    // 设置jwt认证白名单，比如/api/login登录接口不需要拦截
}).unless({
    path: [
        '/',
        '/auth/user/login',
        '/auth/user/register',
    ]
})

// jwt-token解析
function decode(token) {
    return jwt.verify(token, PRIVATE_KEY);
}

module.exports = {
    jwtAuth,
    decode
}
