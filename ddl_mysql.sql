

    drop table if exists parameter;

    drop table if exists algorithm_result;

    drop table if exists image;

    drop table if exists user;

    create table algorithm_result (
        id bigint not null auto_increment,
        type varchar(255) not null,
        description varchar(255) not null,
        image_id bigint not null,
        user_id bigint not null,
        primary key (id)
    );

    create table image (
        id bigint not null auto_increment,
        image mediumblob,
        primary key (id)
    );

    create table parameter (
        id bigint not null auto_increment,
        algorithm_Result_Id bigint not null,
        symbol varchar(255) not null,
        value double precision not null,
        primary key (id)
    );

    create table user (
        id bigint not null auto_increment,
        email varchar(255) not null,
        password_hash varchar(255) not null,
        role varchar(255) not null,
        primary key (id)
    );

    alter table user 
        add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);

    alter table parameter 
        add constraint FK_fxiyt9dpik3yoj56v1rdis3j8 
        foreign key (algorithm_Result_Id) 
        references algorithm_result (id);

INSERT INTO `chaosTheory`.`user` (`id`, `email`, `password_hash`, `role`) VALUES (NULL, 'admin@admin.com', 'admin', 'ADMIN');

CREATE USER 'megaAdmin'@'%';GRANT ALL PRIVILEGES ON *.* TO 'megaAdmin'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `chaosTheory`.* TO 'megaAdmin'@'%';