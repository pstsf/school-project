DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled BOOL,
);

CREATE SEQUENCE hibernate_sequence START 1;

DROP TABLE IF EXISTS people;
CREATE TABLE people (
    person_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    username VARCHAR(128) UNIQUE REFERENCES users (username),
    age INT,
);