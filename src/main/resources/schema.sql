DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled BOOL,
);

CREATE SEQUENCE hibernate_sequence START 1;

DROP TABLE IF EXISTS person;
CREATE TABLE person (
    person_id BIGINT PRIMARY KEY auto_increment,
    firstname VARCHAR(32),
    lastname VARCHAR(32),
    username VARCHAR(128) UNIQUE REFERENCES users (username),
    birth_date DATE,
    address VARCHAR(64),
    postal_code VARCHAR(5),
    town VARCHAR(32),
    role VARCHAR(16)
);

DROP TABLE IF EXISTS klassenbuch;
CREATE TABLE klassenbuch(
    klassenbuch_id BIGINT PRIMARY KEY auto_increment,
    klassen_stufe INTEGER,
    klassen_name VARCHAR(16),
    klassen_zusatz VARCHAR(8),
    period_start DATE,
    period_end DATE,
    archived BOOLEAN,
    owner_id BIGINT
);