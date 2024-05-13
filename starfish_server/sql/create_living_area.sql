drop table if exists `living_area`;
create table `living_area`
(
    `id`          bigint not null auto_increment comment 'id',
    `area_name`   varchar(50) comment '小区名称',
    `area_desc`   varchar(50) comment '小区介绍',
    `longitude`   varchar(50) comment '经度',
    `latitude`    varchar(50) comment '纬度',
    `build_date`  varchar(50) comment '建造时间',
    `create_time` date comment '创建时间',
    `status`      int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '小区表';

insert into living_area (area_name, area_desc, longitude, latitude, build_date, create_time, status)
values ('翻斗花园二期', '近地铁', '', '','2024-05-13 13:14:00','2024-05-13 13:14:00', 0);
