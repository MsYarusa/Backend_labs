CREATE TABLE users
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    password varchar(64) not null,
    username varchar(64) not null unique,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE todos
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    completed boolean NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;