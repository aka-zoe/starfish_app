drop table if exists `house_tag`;
create table `house_tag`
(
    `id`           bigint not null auto_increment comment 'id',
    `house_res_id` bigint comment '房源id',
    `name`         varchar(50) comment '标签名称',
    `type`         int comment '标签类型：0=hot',
    `create_time`  date comment '创建时间',
    `status`       int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '房源标签表';

insert into house_tag (house_res_id, name, type, create_time, status)
values (1, '近地铁', 0, '2024-05-13 13:14:00', 0);
insert into house_tag (house_res_id, name, type, create_time, status)
values (1, '在线签约', 0, '2024-05-13 13:14:00', 0);
insert into house_tag (house_res_id, name, type, create_time, status)
values (1, '整租', 1, '2024-05-13 13:14:00', 0);
