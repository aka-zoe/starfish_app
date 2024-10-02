// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`           bigint not null auto_increment comment 'id',
 *     `houseResId`   bigint comment '房源id',
 *     `bookedTime`   bigint comment '预约时间',
 *     `userId`       bigint comment '预约人id',
 *     `bookedUserId` bigint comment '被预约人id',
 *     `userPhone`    varchar(15) comment '预约人电话',
 *     `userName`     varchar(15) comment '预约人姓名',
 *     `status`       int comment '状态（1=待处理、2=超时未处理、3=已处理、4=已关闭）',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const bookedHouseModel = sequelize.define('booked_house', {
    houseResId: {type: DataTypes.BIGINT},
    bookedTime: {type: DataTypes.STRING},
    userId: {type: DataTypes.BIGINT},
    bookedUserId: {type: DataTypes.BIGINT},
    userPhone: {type: DataTypes.STRING},
    userName: {type: DataTypes.STRING},
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
module.exports = bookedHouseModel;
