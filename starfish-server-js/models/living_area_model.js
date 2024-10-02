// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`          bigint not null auto_increment comment 'id',
 *     `area_name`   varchar(50) comment '小区名称',
 *     `area_desc`   varchar(50) comment '小区介绍',
 *     `area_address`   varchar(255) comment '小区地址',
 *     `longitude`   varchar(50) comment '经度',
 *     `latitude`    varchar(50) comment '纬度',
 *     `build_date`  varchar(50) comment '建造时间',
 *     `create_time` date comment '创建时间',
 *     `status`      int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const livingAreaModel = sequelize.define('living_area', {
    area_name: {type: DataTypes.STRING},
    area_desc: {type: DataTypes.STRING},
    area_address: {type: DataTypes.STRING},
    longitude: {type: DataTypes.STRING},
    latitude: {type: DataTypes.INTEGER},
    build_date: {type: DataTypes.STRING},
    create_time: {type: DataTypes.DATE},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'living_area',
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
//     await betterChoiceModel.sync();
// }())
module.exports = livingAreaModel;
