// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *    `id`                   bigint not null auto_increment comment 'id',
 *     `um_host`              varchar(255) comment '友盟的接口域名',
 *     `um_app_master_secret` varchar(255) comment '友盟应用注册后的MasterSecret',
 *     `um_app_key`           varchar(255) comment '友盟应用注册后的APPKey',
 *     `upload_file_path`     varchar(255) comment '文件上传的路径，指定你服务器的文件绝对路径',
 * @type {ModelCtor<Model>}
 */
// 定义模型
const configModel = sequelize.define('config', {
    um_host: {type: DataTypes.STRING},
    um_app_master_secret: {type: DataTypes.STRING},
    um_app_key: {type: DataTypes.STRING},
    upload_file_path: {type: DataTypes.STRING},
}, {
    sequelize,
    timestamps: false,
    tableName: 'config',
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
module.exports = configModel;
