drop table if exists `news`;
create table `news`
(
    `id`            bigint not null auto_increment comment 'id',
    `title`         varchar(50) comment '标题',
    `subTitle`      varchar(50) comment '副标题',
    `type`          int comment '1=最新咨询、2=热门资讯',
    `tag`           varchar(50) comment '房产新闻（随填写内容，需做长度判断，不能超过6个字）',
    `dianZan`       bigint comment '点赞',
    `pingLun`       bigint comment '评论数',
    `imageUrl`      varchar(255) comment '图片地址',
    `contentUrl`    varchar(255) comment '内容链接',
    `createTime`    bigint comment '创建时间 时间戳',
    `operationTime` bigint comment '修改时间 时间戳',
    `createBy`      bigint comment '创建人用户id',
    `editBy`        bigint comment '修改人用户id',
    `status`        int comment '1=正常、-1=隐藏/下架',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '资讯表';

insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 1, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 1, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 1, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 2, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 2, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 2, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
insert into news (title, subTitle, type, tag, dianZan, pingLun, imageUrl, contentUrl, createTime, operationTime,
                  createBy, editBy, status)
values ('北京市场行情1', '副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1', 2, '房产新闻', 100, 22,
        'https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg',
        'https://juejin.cn/post/7107608301017251876', 1720349602, 1720349602, 1, 1, 1);
