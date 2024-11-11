--liquibase formatted sql
--changeset multipledb:users_pg_1  runOnChange:true

CREATE TABLE IF NOT EXISTS users_pg_1
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50) NOT NULL,
    first_name VARCHAR(100),
    last_name  VARCHAR(100)
);

BEGIN;

INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('jdoe', 'John', 'Doe');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('asmith', 'Alice', 'Smith');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('bthompson', 'Bob', 'Thompson');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('cjohnson', 'Catherine', 'Johnson');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('dlee', 'David', 'Lee');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('efoster', 'Emma', 'Foster');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('fmartin', 'Frank', 'Martin');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('gharris', 'Grace', 'Harris');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('hsanders', 'Henry', 'Sanders');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('ijames', 'Isabella', 'James');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('jclark', 'Jacob', 'Clark');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('kpatel', 'Karen', 'Patel');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('lmorgan', 'Liam', 'Morgan');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('nbrown', 'Noah', 'Brown');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('osmith', 'Olivia', 'Smith');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('pparker', 'Paul', 'Parker');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('rlee', 'Rachel', 'Lee');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('scarter', 'Sophia', 'Carter');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('tmoore', 'Thomas', 'Moore');
INSERT INTO users_pg_1 (username, first_name, last_name) VALUES ('uwilson', 'Uma', 'Wilson');

COMMIT;