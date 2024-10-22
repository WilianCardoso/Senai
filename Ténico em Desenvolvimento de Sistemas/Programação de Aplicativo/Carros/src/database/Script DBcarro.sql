--WIlian Gabriel Cardoso
--JDK 17
--Apache NetBeans IDE 12.6

----------------------------------Script----------------------------------------
CREATE SCHEMA DBcarro;

CREATE TABLE Car(
cod_car INT NOT NULL AUTO_INCREMENT,
desc_car VARCHAR(255) NOT NULL,
pot_car INT NOT NULL,
cor_car VARCHAR(50) NOT NULL,
PRIMARY KEY (cod_car)
);