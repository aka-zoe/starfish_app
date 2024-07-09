drop table if exists `booked_house`;
create table `booked_house`
(
    `id`           bigint not null auto_increment comment 'id',
    `houseResId`   bigint comment '房源id',
    `bookedTime`   bigint comment '预约时间',
    `userId`       bigint comment '预约人id',
    `bookedUserId` bigint comment '被预约人id',
    `userPhone`    varchar(15) comment '预约人电话',
    `userName`     varchar(15) comment '预约人姓名',
    `status`       int comment '状态（1=待处理、2=超时未处理、3=已处理、4=已关闭）',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '房源预约表';

insert into booked_house (houseResId, bookedTime, userId, bookedUserId, userPhone, userName, status)
values (1, 1720349602, 1, 1, '1001001001', 'GG1', 1),
       (1, 1720349603, 1, 1, '1001001002', 'GG2', 1),
       (1, 1720349604, 1, 1, '1001001003', 'GG3', 1);
