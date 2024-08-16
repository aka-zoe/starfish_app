drop table if exists `message`;
create table `message`
(
    `id`         bigint not null auto_increment comment 'id',
    `userId`     bigint comment '用户id',
    `title`      varchar(50) comment '标题',
    `subTitle`   varchar(150) comment '副标题',
    `content`    varchar(1024) comment '消息内容',
    `createTime` bigint comment '创建时间 时间戳',
    `status`     int comment '1=未读、2=已读',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '消息表';

insert into message (userId, title, subTitle, content, createTime, status)
values (1, '消息标题', '副标题：北京市场行情1北京市场', '消息内容详细内容', 1720349602, 1);

insert into message (userId, title, subTitle, content, createTime, status)
values (1, '消息标题', '副标题：北京市场行情1北京市场', '消息内容详细内容', 1720349602, 1);

insert into message (userId, title, subTitle, content, createTime, status)
values (1, '消息标题', '副标题：北京市场行情1北京市场', '消息内容详细内容', 1720349602, 1);

