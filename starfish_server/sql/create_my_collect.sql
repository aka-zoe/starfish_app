drop table if exists `my_collect`;
create table `my_collect`
(
    `id`          bigint not null auto_increment comment 'id',
    `collectType` int comment '收藏分类：1=房源，2=资讯',
    `collectTime` bigint comment '收藏时间',
    `houseResId`  bigint comment '收藏房源id',
    `newsId`      bigint comment '收藏资讯id',
    `userId`      bigint comment '收藏者id',
    `title`       varchar(255) comment '收藏内容标题',

    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '房源预约表';

insert into my_collect (collectType, collectTime, houseResId, newsId, userId, title)
values (1, 1720349602, 1, 1, 1, '收藏房源内容标题'),
       (1, 1720349602, 1, 1, 1, '收藏房源内容标题'),
       (2, 1720349602, 1, 1, 1, '收藏资讯内容标题'),
       (2, 1720349602, 1, 1, 1, '收藏资讯内容标题');
