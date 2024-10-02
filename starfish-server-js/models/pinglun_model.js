// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`         bigint not null auto_increment comment 'id',
 *     `type`       int comment '1=资讯、2=评论',
 *     `dianZan`    bigint comment '评论的点赞数',
 *     `createTime` bigint comment '评论时间 时间戳',
 *     `createBy`   bigint comment '评论人用户id',
 *     `newsId`     bigint comment '资讯id（type=1才有）',
 *     `userId`     bigint comment '被评论的用户id（type=2，评论的评论才有）',
 *     `pingLunId`  bigint comment '评论id（type=2，评论的评论才有）',
 *     `content`    varchar(255) comment '评论内容',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const pinglunModel = sequelize.define('pinglun', {
    type: {type: DataTypes.INTEGER},
    dianZan: {type: DataTypes.BIGINT},
    createTime: {type: DataTypes.BIGINT},
    createBy: {type: DataTypes.BIGINT},
    newsId: {type: DataTypes.BIGINT},
    userId: {type: DataTypes.BIGINT},
    pingLunId: {type: DataTypes.BIGINT},
    content: {type: DataTypes.STRING},
}, {
    sequelize,
    timestamps: false,
    tableName: 'pinglun',
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
module.exports = pinglunModel;
