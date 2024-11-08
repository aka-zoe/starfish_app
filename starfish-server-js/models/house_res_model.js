// models/User_model.js
const {DataTypes} = require('sequelize');
const sequelize = require('../db/db');
/**
 *   `id`               bigint not null auto_increment comment 'id',
 *     `name`             varchar(255) comment '房源名称',
 *     `image`            varchar(255) comment '缩略图',
 *     `house_image_id`   bigint comment '房源图片id',
 *     `house_desc`       varchar(255) comment '比如近地铁、距离地铁1.5km等',
 *     `lease_type`       int comment '0=整租、1=合租',
 *     `rent`             decimal comment '租金,单位为元/月',
 *     `service_charge`   decimal comment '中介费,单位为元',
 *     `house_type_id`    bigint comment '户型id',
 *     `house_type`       int comment '0=次卧、1=主卧、2=整租',
 *     `direction`        varchar(50) comment '朝向',
 *     `check_in_date`    varchar(50) comment '入住时间',
 *     `total_floor`      int comment '总楼层',
 *     `current_floor`    int comment '当前楼层',
 *     `house_area_id`    bigint comment '小区id',
 *     `acreage`          int comment '面积，单位为平方米',
 *     `publish_date`     varchar(50) comment '发布时间',
 *     `fitment`          varchar(50) comment '装修类型：精装修',
 *     `payment_type`     int comment '0=押一付三，1=月付，2=押一付一，3=押一付二，4=整年租',
 *     `bed`              int comment '床：1=true,0=false',
 *     `washing_machine`  int comment '洗衣机：1=true,0=false',
 *     `refrigerator`     int comment '冰箱：1=true,0=false',
 *     `air_conditioner`  int comment '空调：1=true,0=false',
 *     `wifi`             int comment 'wifi：1=true,0=false',
 *     `sofa`             int comment '沙发：1=true,0=false',
 *     `table_chair`      int comment '桌椅：1=true,0=false',
 *     `tv`               int comment '电视：1=true,0=false',
 *     `water_heater`     int comment '热水器：1=true,0=false',
 *     `cook`             int comment '可做饭：1=true,0=false',
 *     `heating`          int comment '暖气：1=true,0=false',
 *     `balcony`          int comment '阳台：1=true,0=false',
 *     `carport`          int comment '车位：1=true,0=false',
 *     `longitude`        varchar(50) comment '经度',
 *     `latitude`         varchar(50) comment '纬度',
 *     `publisher`        varchar(50) comment '发布人',
 *     `publisher_number` varchar(50) comment '发布人电话',
 *     `tag_id`           bigint comment '房源tag id',
 *     `publisher_id`     bigint comment '发布人id',
 *     `publisher_type`   varchar(50) comment '发布人类型',
 *     `publisher_head`   varchar(255) comment '发布人头像',
 *     `create_time`      varchar(50) comment '创建时间',
 *     `status`           int comment '状态：0=正常 1=停用 -1=删除',
 * @type {ModelCtor<Model>}
 */
// 定义 User_model 模型
const houseResModel = sequelize.define('house_res', {
    name: {type: DataTypes.STRING},
    image: {type: DataTypes.STRING},
    house_image_id: {type: DataTypes.BIGINT},
    house_desc: {type: DataTypes.STRING},
    lease_type: {type: DataTypes.INTEGER},
    rent: {type: DataTypes.DECIMAL},
    service_charge: {type: DataTypes.DECIMAL},
    house_type_id: {type: DataTypes.BIGINT},
    house_type: {type: DataTypes.INTEGER},
    direction: {type: DataTypes.STRING},
    check_in_date: {type: DataTypes.STRING},
    total_floor: {type: DataTypes.INTEGER},
    current_floor: {type: DataTypes.INTEGER},
    house_area_id: {type: DataTypes.BIGINT},
    acreage: {type: DataTypes.INTEGER},
    publish_date: {type: DataTypes.STRING},
    fitment: {type: DataTypes.STRING},
    payment_type: {type: DataTypes.INTEGER},
    bed: {type: DataTypes.INTEGER},
    washing_machine: {type: DataTypes.INTEGER},
    refrigerator: {type: DataTypes.INTEGER},
    air_conditioner: {type: DataTypes.INTEGER},
    wifi: {type: DataTypes.INTEGER},
    sofa: {type: DataTypes.INTEGER},
    table_chair: {type: DataTypes.INTEGER},
    tv: {type: DataTypes.INTEGER},
    water_heater: {type: DataTypes.INTEGER},
    cook: {type: DataTypes.INTEGER},
    heating: {type: DataTypes.INTEGER},
    balcony: {type: DataTypes.INTEGER},
    carport: {type: DataTypes.INTEGER},
    longitude: {type: DataTypes.STRING},
    latitude: {type: DataTypes.STRING},
    publisher: {type: DataTypes.STRING},
    publisher_number: {type: DataTypes.STRING},
    tag_id: {type: DataTypes.BIGINT},
    publisher_id: {type: DataTypes.BIGINT},
    publisher_type: {type: DataTypes.STRING},
    publisher_head: {type: DataTypes.STRING},
    create_time: {type: DataTypes.STRING},
    status: {type: DataTypes.INTEGER},
}, {
    sequelize,
    timestamps: false,
    tableName: 'house_res',
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
//     await bannerModel.sync();
// }())
module.exports = houseResModel;
