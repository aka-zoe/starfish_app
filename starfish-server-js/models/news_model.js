// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`            bigint not null auto_increment comment 'id',
 *     `title`         varchar(50) comment '标题',
 *     `subTitle`      varchar(50) comment '副标题',
 *     `type`          int comment '1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普',
 *     `tag`           varchar(50) comment '房产新闻（随填写内容，需做长度判断，不能超过6个字）',
 *     `dianZan`       bigint comment '点赞',
 *     `pingLun`       bigint comment '评论数',
 *     `imageUrl`      varchar(1024) comment '图片地址',
 *     `contentUrl`    varchar(255) comment '内容链接',
 *     `createTime`    bigint comment '创建时间 时间戳',
 *     `operationTime` bigint comment '修改时间 时间戳',
 *     `createBy`      bigint comment '创建人用户id',
 *     `editBy`        bigint comment '修改人用户id',
 *     `status`        int comment '1=正常、-1=隐藏/下架',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const newsModel = sequelize.define('news', {
    title: {type: DataTypes.STRING},
    subTitle: {type: DataTypes.STRING},
    type: {type: DataTypes.INTEGER},
    tag: {type: DataTypes.STRING},
    dianZan: {type: DataTypes.BIGINT},
    pingLun: {type: DataTypes.BIGINT},
    imageUrl: {type: DataTypes.STRING},
    contentUrl: {type: DataTypes.STRING},
    createTime: {type: DataTypes.BIGINT},
    operationTime: {type: DataTypes.BIGINT},
    createBy: {type: DataTypes.BIGINT},
    editBy: {type: DataTypes.BIGINT},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'news',
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
module.exports = newsModel;
