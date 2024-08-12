drop table if exists `config`;
create table `config`
(
    `id`                   bigint not null auto_increment comment 'id',
    `um_host`              varchar(255) comment '友盟的接口域名',
    `um_app_master_secret` varchar(255) comment '友盟应用注册后的MasterSecret',
    `um_app_key`           varchar(255) comment '友盟应用注册后的APPKey',
    `upload_file_path`     varchar(255) comment '文件上传的路径，指定你服务器的文件绝对路径',
    primary key (`id`)

) engine = innodb
  default charset = utf8mb4 comment '项目配置信息表';

insert into config (um_host, um_app_master_secret, um_app_key, upload_file_path)
values ('https://msgapi.umeng.com', 'amonmll8fkzbqbab0f7vz5xptyobd3x1', '66a64da0192e0574e74d5585',
        '/Users/gongsensen/Downloads/UploadImageForStarfish/fileUploadPath');
