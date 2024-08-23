drop table if exists `user`;
create table `user`
(
    `id`          bigint not null auto_increment comment 'id',
    `name`        varchar(50) comment '用户名',
    `password`    varchar(255) comment '密码',
    `role`        varchar(50) comment '角色',
    `create_time` varchar(50) comment '创建时间',
    `work_number` varchar(50) comment '工号',
    `pid`         varchar(50) comment '用户的唯一ID用于IM注册',
    `email`       varchar(255) comment '邮箱',
    `address`     varchar(255) comment '地址',
    `phone`       varchar(18) comment '手机号',
    `gender`      varchar(50) comment '性别',
    `um_token`    varchar(255) comment '友盟token',
    `tag`         varchar(50) comment '推送用户tag',
    `age`         int comment '年龄',
    `open_msg`    int comment '是否开启消息：0 关闭，1 开启',
    `status`      int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '用户表';

insert into user (name, password, role, create_time, work_number,pid, email, address, phone, gender, um_token, tag, age,
                  open_msg, status)
values ('admin', '123456', 'admin', '2023-10-21 22:24:00', '23789', '32387155', 'asd.asd@asd.com', '苏州', '15012345432',
        '男', 'AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK', 'normal', 12,
        0, 0);
