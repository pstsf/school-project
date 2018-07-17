INSERT INTO person (id, name, username) VALUES
	('1', 'David Polzer', 'david@example.com');

INSERT INTO users (user_id, username, password, enabled, person_id) VALUES
	('1', 'david@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, '1');
