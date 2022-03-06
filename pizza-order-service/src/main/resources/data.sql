DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
 );

INSERT INTO users (username, password) VALUES
('joe', '$2a$12$syNIjpEKitjgh26C2Q3GdOxuUjxOi/G64BTl1y8yVUoZjySDaZbrS')
