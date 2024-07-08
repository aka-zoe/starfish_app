drop table if exists `pinglun`;
create table `pinglun`
(
    `id`         bigint not null auto_increment comment 'id',
    `type`       int comment '1=资讯、2=评论',
    `dianZan`    bigint comment '评论的点赞数',
    `createTime` bigint comment '评论时间 时间戳',
    `createBy`   bigint comment '评论人用户id',
    `newsId`     bigint comment '资讯id（type=1才有）',
    `userId`     bigint comment '被评论的用户id（type=2，评论的评论才有）',
    `pingLunId`  bigint comment '评论id（type=2，评论的评论才有）',
    `content`    varchar(255) comment '评论内容',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '评论表';

insert into pinglun (type, createTime, dianZan, createBy, newsId, userId, pingLunId, content)
values (1, 1720349602, 3, 1, 1, -1, -1, '测试评论内容');
insert into pinglun (type, createTime, dianZan, createBy, newsId, userId, pingLunId, content)
values (1, 1720349602, 3, 1, 1, -1, -1, '测试评论内容2');
insert into pinglun (type, createTime, dianZan, createBy, newsId, userId, pingLunId, content)
values (2, 1720349602, 1, 1, -1, -1, 1, '测试评论内容2');
insert into pinglun (type, createTime, dianZan, createBy, newsId, userId, pingLunId, content)
values (2, 1720349602, 2, 1, -1, 1, 1, '测试评论内容2');
