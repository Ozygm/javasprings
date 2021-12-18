CREATE DATABASE examen;
use examen;

CREATE TABLE examen.user (
  user_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(255) NULL,
  password_confirmation VARCHAR(255) NULL,
role  VARCHAR (45) NULL,
  PRIMARY KEY (user_id));

CREATE TABLE examen.shows (
  id_show INT NOT NULL AUTO_INCREMENT,
  show_title VARCHAR(45) NULL,
  show_network VARCHAR(45) NULL,
  PRIMARY KEY (id_show));
  

INSERT INTO shows (show_title, show_network) VALUES ('Show1', 'network1'); 

CREATE TABLE examen.rating (
  rating_id INT NOT NULL AUTO_INCREMENT,
  rating INT NULL,
  PRIMARY KEY (rating_id));
  
  select * from user;











