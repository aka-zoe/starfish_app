// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`         bigint not null auto_increment comment 'id',
 *     `type`       int comment '1=资讯、2=评论',
 *     `createTime` bigint comment '点赞时间 时间戳',
 *     `createBy`   bigint comment '点赞人用户id',
 *     `newsId`     bigint comment '资讯id',
 *     `pingLunId`  bigint comment '评论id',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const dianzanModel = sequelize.define('dianzan', {
    type: {type: DataTypes.INTEGER},
    createTime: {type: DataTypes.BIGINT},
    createBy: {type: DataTypes.BIGINT},
    newsId: {type: DataTypes.BIGINT},
    pingLunId: {type: DataTypes.BIGINT},
}, {
    sequelize,
    timestamps: false,
    tableName: 'dianzan',
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
module.exports = dianzanModel;
