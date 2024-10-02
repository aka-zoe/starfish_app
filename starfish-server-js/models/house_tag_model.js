// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`           bigint not null auto_increment comment 'id',
 *     `house_res_id` bigint comment '房源id',
 *     `name`         varchar(50) comment '标签名称',
 *     `type`         int comment '标签类型：0=hot',
 *     `create_time`  date comment '创建时间',
 *     `status`       int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const houseTagModel = sequelize.define('house_tag', {
    house_res_id: {type: DataTypes.BIGINT},
    name: {type: DataTypes.STRING},
    type: {type: DataTypes.INTEGER},
    create_time: {type: DataTypes.DATE},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'house_tag',
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
module.exports = houseTagModel;
