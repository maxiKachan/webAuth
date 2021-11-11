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

INSERT INTO users (email, first_name, last_name, user_password, role)
VALUES ('user@gmail.com','user','user','$2a$10$GOrYvaPRepf270qyiuBqcu9mw1WA8GrWOWQ8xbQsBQRFd1g2pj9be', 'USER'),
       ('admin@gmail.com', 'admin', 'admin', '$2a$10$2RuJ5TlUdtHnhPtZuAPW/eFMsL4LE.1rdBrH0GF5GnuXw7u7Sn0HC', 'USER');