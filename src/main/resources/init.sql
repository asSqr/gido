DROP DATABASE IF EXISTS gidodb;

CREATE DATABASE gidodb CHARACTER SET utf8;

USE gidodb;

DROP USER IF EXISTS 'app-user'@'%';
SET GLOBAL validate_password_policy=LOW;
CREATE USER 'app-user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON gidodb.* TO 'app-user'@'%';
