CREATE TABLE users
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    password VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE todos
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    completed boolean NOT NULL,
    PRIMARY KEY (id)
);