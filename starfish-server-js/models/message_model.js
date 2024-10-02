// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`         bigint not null auto_increment comment 'id',
 *     `userId`     bigint comment '用户id',
 *     `title`      varchar(50) comment '标题',
 *     `subTitle`   varchar(150) comment '副标题',
 *     `content`    varchar(1024) comment '消息内容',
 *     `createTime` bigint comment '创建时间 时间戳',
 *     `status`     int comment '1=未读、2=已读',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const messageModel = sequelize.define('message', {
    userId: {type: DataTypes.BIGINT},
    title: {type: DataTypes.STRING},
    subTitle: {type: DataTypes.STRING},
    content: {type: DataTypes.STRING},
    createTime: {type: DataTypes.BIGINT},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'message',
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
module.exports = messageModel;
