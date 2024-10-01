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
values ('https://ww4.sinaimg.cn/mw690/006joT8tgy1hofwddmarzj30j60nxq6d.jpg', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://wx3.sinaimg.cn/orj480/006iiEhUly1hitpet5bglj30u00gvgox.jpg', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://ww4.sinaimg.cn/mw690/006joT8tgy1hofwddmarzj30j60nxq6d.jpg', 'https://www.baidu.com',
        0, '搞笑活动', 0),
       ('https://wx3.sinaimg.cn/orj480/006iiEhUly1hitpet5bglj30u00gvgox.jpg', 'https://www.baidu.com',
        0, '搞笑活动', 0);

# select * from banner where id=1;
