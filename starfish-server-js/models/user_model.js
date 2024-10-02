// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *     `id`          bigint not null auto_increment comment 'id',
 *     `name`        varchar(50) comment '用户名',
 *     `password`    varchar(255) comment '密码',
 *     `role`        varchar(50) comment '角色',
 *     `create_time` varchar(50) comment '创建时间',
 *     `work_number` varchar(50) comment '工号',
 *     `pid`         varchar(50) comment '用户的唯一ID用于IM注册',
 *     `email`       varchar(255) comment '邮箱',
 *     `address`     varchar(255) comment '地址',
 *     `phone`       varchar(18) comment '手机号',
 *     `gender`      varchar(50) comment '性别',
 *     `um_token`    varchar(255) comment '友盟token',
 *     `tag`         varchar(50) comment '推送用户tag',
 *     `age`         int comment '年龄',
 *     `open_msg`    int comment '是否开启消息：0 关闭，1 开启',
 *     `status`      int comment '状态：0=正常 1=停用 -1=删除',
 *     primary key (`id`)
 * @type {ModelCtor<Model>}
 */
// 定义 User_model 模型
const User_model = sequelize.define('user', {
    // id: {
    //     type: DataTypes.BIGINT,
    // autoIncrement: true,
    // notNull: true,
    // comment: "自增id"
    // },
    name: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    password: {
        type: DataTypes.STRING,
        // VARCHAR: 255
    },
    role: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    create_time: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    work_number: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    pid: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    email: {
        type: DataTypes.STRING,
        // VARCHAR: 255
    },
    address: {
        type: DataTypes.STRING,
        // VARCHAR: 255
    },
    phone: {
        type: DataTypes.STRING,
        // VARCHAR: 18
    },
    gender: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    um_token: {
        type: DataTypes.STRING,
        // VARCHAR: 255
    },
    tag: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    age: {
        type: DataTypes.INTEGER,
    },
    open_msg: {
         type: DataTypes.INTEGER,
    },
    status: {
         type: DataTypes.INTEGER,
    },
}, {
    sequelize,
    timestamps: false,
    tableName: 'user',
    indexes: [{
        name: "PRIMARY",
        unique: true,
        using: "BTREE",
        fields: [{
            name: "id"
        }]
    },]
});
// (async function () {
//     //如果表不存在则创建该表
//     await User_model.sync();
// }())
module.exports = User_model;
