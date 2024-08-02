drop table if exists `user`;
create table `user`
(
    `id`          bigint not null auto_increment comment 'id',
    `name`        varchar(50) comment '用户名',
    `password`    varchar(255) comment '密码',
    `role`        varchar(50) comment '角色',
    `create_time` varchar(50) comment '创建时间',
    `work_number` varchar(50) comment '工号',
    `email`       varchar(255) comment '邮箱',
    `address`     varchar(255) comment '地址',
    `phone`       varchar(18) comment '手机号',
    `gender`      varchar(50) comment '性别',
    `um_token`    varchar(255) comment '友盟token',
    `tag`         varchar(50) comment '推送用户tag',
    `age`         int comment '年龄',
    `status`      int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '用户表';

insert into user (name, password, role, create_time, work_number, email, address, phone, gender, um_token, tag, age,
                  status)
values ('Zoe', '123456', 'admin', '2023-10-21 22:24:00', '23789', 'sensen.gong@alpha-ess.com', '苏州', '15061442013',
        '男', 'AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK', 'normal', 25,
        0);
