// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`          bigint not null auto_increment comment 'id',
 *     `house_id`    bigint comment '房源id',
 *     `image_url`   varchar(255) comment '房源图片链接',
 *     `image_name`  varchar(255) comment '标签名称',
 *     `create_time` date comment '创建时间',
 *     `status`      int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const dianzanModel = sequelize.define('dianzan', {
    house_id: {type: DataTypes.BIGINT},
    image_url: {type: DataTypes.STRING},
    image_name: {type: DataTypes.STRING},
    create_time: {type: DataTypes.DATE},
    status: {type: DataTypes.INTEGER},
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
