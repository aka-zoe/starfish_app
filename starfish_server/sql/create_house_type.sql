drop table if exists `house_type`;
create table `house_type`
(
    `id`          bigint not null auto_increment comment 'id',
    `type_name`   varchar(255) comment '户型',
    `full_name`   varchar(255) comment '户型全称',
    `create_time` date comment '创建时间',
    `status`      int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '户型表';

insert into house_type (type_name, full_name, create_time, status)
values ('一室一厅', '一室一厅一卫', '2024-05-13 13:14:00', 0);
insert into house_type (type_name, full_name, create_time, status)
values ('二室一厅', '二室一厅一卫', '2024-05-13 13:14:00', 0);
insert into house_type (type_name, full_name, create_time, status)
values ('三室一厅', '三室一厅两卫', '2024-05-13 13:14:00', 0);
insert into house_type (type_name, full_name, create_time, status)
values ('四室两厅', '四室两厅两卫', '2024-05-13 13:14:00', 0);
