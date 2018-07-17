DROP TABLE IF EXISTS person;
CREATE TABLE person (
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    username VARCHAR(128) UNIQUE,
    birth_date DATE,
    address VARCHAR(64),
    postal_code VARCHAR(5),
    town VARCHAR(32)
);


DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE REFERENCES person (username),
    password VARCHAR(256),
    enabled BOOLEAN,
    person_id BIGINT REFERENCES person (id),
);

CREATE SEQUENCE hibernate_sequence START 1;


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
DROP TABLE IF EXISTS not_attendance;
CREATE TABLE not_attendance(
    id BIGINT PRIMARY KEY auto_increment,
    date DATE,
    reason VARCHAR(32)
);

DROP TABLE IF EXISTS attendance_person;
CREATE TABLE attendance_person(
    na_id BIGINT REFERENCES not_attendance(id),
    person_id BIGINT REFERENCES person(id)
);

DROP TABLE IF EXISTS attendance_klassenbuch;
CREATE TABLE attendance_klassenbuch(
    na_id BIGINT REFERENCES not_attendance(id),
    kb_id BIGINT REFERENCES klassenbuch(id),
);

DROP TABLE IF EXISTS not_attendance;
CREATE TABLE not_attendance(
    person_id BIGINT REFERENCES person(id),
    date DATE,
    reason VARCHAR(32)
);