const createError = require('http-errors');
const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const bodyParser = require('body-parser'); // 引入body-parser模块

// 引入route管理路由 routes/index.js
const routes = require('./routes');

const app = express();
const port = 9900;
// view engine setup

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());

app.use(bodyParser.json()); // 解析json数据格式
app.use(bodyParser.urlencoded({extended: true})); // 解析form表单提交的数据application/x-www-form-urlencoded


//统一管理所有模块的路由
app.use('/', routes);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
    next(createError(404));
});

// // error handler
// app.use(function (err, req, res, next) {
//     // set locals, only providing error in development
//     res.locals.message = err.message;
//     res.locals.error = req.app.get('env') === 'development' ? err : {};
//
//     // render the error page
//     res.status(err.status || 500);
//     res.render('error');
// });

// 配置允许跨域
app.all('*', function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*")
    res.header('Access-Control-Allow-Headers', 'Content-Type')
    res.header('Access-Control-Allow-Methods', 'GET,POST,PUT,DELETE')
    if (req.method.toLowerCase() == 'options') {
        res.send(200); // 让options 尝试请求快速结束
    } else {
        next();
    }
})

// 启动服务器
app.listen(port, () => {
    console.log(`服务器正在监听端口 ${port}`);
});

