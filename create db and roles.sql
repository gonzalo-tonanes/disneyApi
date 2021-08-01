CREATE DATABASE IF NOT EXISTS `disney`;

use disney;

CREATE TABLE `rol`(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rolname varchar(20)
);

INSERT INTO `rol`(`rolname`) VALUES ("ROLE_ADMIN");
INSERT INTO `rol`(`rolname`) VALUES ("ROLE_USER");