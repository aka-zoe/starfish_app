// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`          bigint not null auto_increment comment 'id',
 *     `collectType` int comment '收藏分类：1=房源，2=资讯',
 *     `collectTime` bigint comment '收藏时间',
 *     `houseResId`  bigint comment '收藏房源id',
 *     `newsId`      bigint comment '收藏资讯id',
 *     `userId`      bigint comment '收藏者id',
 *     `title`       varchar(255) comment '收藏内容标题',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const myCollectModel = sequelize.define('my_collect', {
    collectType: {type: DataTypes.INTEGER},
    collectTime: {type: DataTypes.BIGINT},
    houseResId: {type: DataTypes.BIGINT},
    newsId: {type: DataTypes.BIGINT},
    userId: {type: DataTypes.BIGINT},
    title: {type: DataTypes.STRING},
}, {
    sequelize,
    timestamps: false,
    tableName: 'my_collect',
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
module.exports = myCollectModel;
