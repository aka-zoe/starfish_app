drop table if exists `house_img`;
create table `house_img`
(
    `id`          bigint not null auto_increment comment 'id',
    `house_id`    bigint comment '房源id',
    `image_url`   varchar(255) comment '房源图片链接',
    `image_name`  varchar(255) comment '标签名称',
    `create_time` date comment '创建时间',
    `status`      int comment '状态：0=正常 1=停用 -1=删除',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '房源标签表';

insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);
insert into house_img (house_id, image_url, image_name, create_time, status)
values (1, 'https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png',
        '6012df31dff3413bb7815b136e98207e', '2024-05-13 13:14:00', 0);

