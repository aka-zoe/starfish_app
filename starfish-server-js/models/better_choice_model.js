// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`       bigint not null auto_increment comment 'id',
 *     `title`    varchar(50) comment '标题',
 *     `subTitle` varchar(50) comment '副标题',
 *     `resId`    bigint comment '资源id',
 *     `imgUrl`   varchar(255) comment '图片地址',
 *     `link`     varchar(255) comment '活动链接',
 *     `type`     int comment '优选类型',
 *     `status`   int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const betterChoiceModel = sequelize.define('better_choice', {
    title: {type: DataTypes.STRING},
    subTitle: {type: DataTypes.STRING },
    resId:{type:DataTypes.BIGINT},
    imgUrl:{type:DataTypes.STRING},
    link:{type:DataTypes.STRING},
    type: {type: DataTypes.INTEGER},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'better_choice',
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
module.exports = betterChoiceModel;
