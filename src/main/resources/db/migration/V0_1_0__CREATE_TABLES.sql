CREATE TABLE users
(
    id       SERIAL,
    password VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE todos
(
    id       SERIAL,
    title VARCHAR(64) NOT NULL,
    completed boolean NOT NULL,
    PRIMARY KEY (id)
);