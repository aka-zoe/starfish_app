drop table if exists `dianzan`;
create table `dianzan`
(
    `id`         bigint not null auto_increment comment 'id',
    `type`       int comment '1=资讯、2=评论',
    `createTime` bigint comment '点赞时间 时间戳',
    `createBy`   bigint comment '点赞人用户id',
    `newsId`     bigint comment '资讯id',
    `pingLunId`  bigint comment '评论id',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '资讯与评论点赞表';

insert into dianzan (type, createTime, createBy, newsId, pingLunId)
values (1, 1720349602, 1, 1, -1);
insert into dianzan (type, createTime, createBy, newsId, pingLunId)
values (2, 1720349602, 1, -1, 1);
