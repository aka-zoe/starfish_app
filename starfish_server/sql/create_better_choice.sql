drop table if exists `better_choice`;
create table `better_choice`
(
    `id`       bigint not null auto_increment comment 'id',
    `title`    varchar(50) comment '标题',
    `subTitle` varchar(50) comment '副标题',
    `resId`    bigint comment '资源id',
    `imgUrl`   varchar(255) comment '图片地址',
    `link`     varchar(255) comment '活动链接',
    `type`     int comment '优选类型',
    `status`   int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '活动表';

insert into better_choice (title, subTitle, resId, imgUrl, link, type, status)
values ('精品装修', '舒适的环境', 1, 'https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg',
        'https://www.baidu.com',
        0, 0);
insert into better_choice (title, subTitle, resId, imgUrl, link, type, status)
values ('温馨小窝', '倦怠的生活', 1, 'https://pic.616pic.com/photoone/00/06/56/61975de20f1487757.jpg',
        'https://www.baidu.com',
        0, 0);
insert into better_choice (title, subTitle, resId, imgUrl, link, type, status)
values ('大牌商圈', '选择更多', 1, 'https://pic.616pic.com/photoone/00/06/37/61975c8c74872813.jpg',
        'https://www.baidu.com',
        0, 0);
