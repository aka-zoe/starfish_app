// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`          bigint not null auto_increment comment 'id',
 *     `type_name`   varchar(255) comment '户型',
 *     `full_name`   varchar(255) comment '户型全称',
 *     `create_time` date comment '创建时间',
 *     `status`      int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const houseTypeModel = sequelize.define('house_type', {
    type_name: {type: DataTypes.STRING},
    full_name: {type: DataTypes.STRING},
    create_time: {type: DataTypes.INTEGER},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'house_type',
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
module.exports = houseTypeModel;
