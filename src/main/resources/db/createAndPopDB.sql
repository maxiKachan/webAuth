DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_id SERIAL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    user_password VARCHAR(255) NOT NULL,
    role VARCHAR(30) DEFAULT ('USER')
);