create schema palogin;
use palogin;

CREATE TABLE login (
  cod_login int NOT NULL AUTO_INCREMENT,
  user_login varchar(50) NOT NULL,
  pas_login varchar(50) NOT NULL,
  nom_login varchar(50) NOT NULL,
  PRIMARY KEY (cod_login)
);

INSERT INTO palogin.login (user_login, pas_login, nom_login) VALUES ('wil', '123', 'wil');

select * from login;
