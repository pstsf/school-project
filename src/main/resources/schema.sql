DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled BOOL
);

CREATE SEQUENCE hibernate_sequence START 1;

DROP TABLE IF EXISTS person;
CREATE TABLE person (
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    username VARCHAR(128) UNIQUE REFERENCES users (username),
    birth_date DATE,
    address VARCHAR(64),
    postal_code VARCHAR(5),
    town VARCHAR(32)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(128)
);

DROP TABLE IF EXISTS role_person;
CREATE TABLE role_person(
    person_id BIGINT REFERENCES person(id),
    role_id BIGINT REFERENCES role(id),
);

DROP TABLE IF EXISTS not_attendance;
CREATE TABLE not_attendance(
    person_id BIGINT REFERENCES person(id),
    date DATE,
    reason VARCHAR(32),
    klassenbuch_id BIGINT REFERENCES klassenbuch(id)
);

DROP TABLE IF EXISTS klassenbuch;
CREATE TABLE klassenbuch(
    id BIGINT PRIMARY KEY auto_increment,
    klassen_stufe INTEGER,
    klassen_name VARCHAR(32),
    klassen_zusatz VARCHAR(8),
    period_start DATE,
    period_end DATE,
    archived BOOLEAN,
    owner_id BIGINT REFERENCES person(id)
);

DROP TABLE IF EXISTS klassenbuch_prsn;
CREATE TABLE klassenbuch_prsn(
    klassenbuch_id BIGINT REFERENCES klassenbuch(id),
    person_id BIGINT REFERENCES person(id)
);
