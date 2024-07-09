drop table if exists `banner`;
create table `banner`
(
    `id`         bigint not null auto_increment comment 'id',
    `imgUrl`     varchar(255) comment '图片地址',
    `link`       varchar(255) comment '活动链接',
    `type`       int comment 'banner类型',
    `activeName` varchar(50) comment '活动名称',
    `status`     int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '活动表';

insert into banner (imgUrl, link, type, activeName, status)
values ('https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png', 'https://www.baidu.com',
        0, '搞笑活动', 0);

# select * from banner where id=1;
