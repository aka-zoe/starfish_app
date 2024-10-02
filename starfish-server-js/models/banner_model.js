// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`         bigint not null auto_increment comment 'id',
 *     `imgUrl`     varchar(255) comment '图片地址',
 *     `link`       varchar(255) comment '活动链接',
 *     `type`       int comment 'banner类型',
 *     `activeName` varchar(50) comment '活动名称',
 *     `status`     int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义 User_model 模型
const bannerModel = sequelize.define('banner', {
    imgUrl: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    link: {
        type: DataTypes.STRING,
        // VARCHAR: 255
    },
    type: {
        type: DataTypes.INTEGER,
        // VARCHAR: 50
    },
    activeName: {
        type: DataTypes.STRING,
        // VARCHAR: 50
    },
    status: {
         type: DataTypes.INTEGER,
    },
}, {
    sequelize,
    timestamps: false,
    tableName: 'banner',
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
//     await bannerModel.sync();
// }())
module.exports = bannerModel;
