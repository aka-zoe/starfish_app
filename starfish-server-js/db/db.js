// // db.js
// const mysql = require('mysql2/promise');
//
// // 创建数据库连接池
// const pool = mysql.createPool({
//     host: 'localhost',
//     user: 'root',
//     password: 'pwd123...',
//     database: 'starfish',
// });
//
// // 导出连接池供其他模块使用
// module.exports = pool;

// db/db.js
const { Sequelize } = require('sequelize');

// 初始化 Sequelize，连接 MySQL 数据库
const sequelize = new Sequelize('starfish', 'root', 'pwd123...', {
    host: 'localhost',
    dialect: 'mysql',
});

//同步数据库
sequelize.sync();

// 测试连接
sequelize.authenticate()
    .then(() => {
        console.log('数据库连接成功');
    })
    .catch((err) => {
        console.error('无法连接数据库:', err);
    });

module.exports = sequelize;
