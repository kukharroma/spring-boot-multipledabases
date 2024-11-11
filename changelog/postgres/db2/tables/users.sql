--liquibase formatted sql
--changeset multipledb:users_pg_2  runOnChange:true

CREATE TABLE IF NOT EXISTS users_pg_2
(
    ldap_user_id         SERIAL PRIMARY KEY,
    ldap_username   VARCHAR(50) NOT NULL,
    ldap_first_name VARCHAR(100),
    ldap_last_name  VARCHAR(100)
);

BEGIN;

INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('jwhite', 'Julia', 'White');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('mwilliams', 'Michael', 'Williams');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('adavis', 'Angela', 'Davis');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('jgarcia', 'Jose', 'Garcia');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('lmartinez', 'Linda', 'Martinez');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('rcampbell', 'Ryan', 'Campbell');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('tscott', 'Tina', 'Scott');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('bgreen', 'Brad', 'Green');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('kmurphy', 'Karen', 'Murphy');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('wchavez', 'Wendy', 'Chavez');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('esanders', 'Edward', 'Sanders');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('jnichols', 'Jessica', 'Nichols');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('fross', 'Frank', 'Ross');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('gphillips', 'Gina', 'Phillips');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('rreed', 'Robert', 'Reed');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('dperez', 'Diana', 'Perez');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('msimmons', 'Marcus', 'Simmons');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('aleon', 'Ashley', 'Leon');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('kparker', 'Kevin', 'Parker');
INSERT INTO users_pg_2 (ldap_username, ldap_first_name, ldap_last_name) VALUES ('sjenkins', 'Sara', 'Jenkins');

COMMIT;
