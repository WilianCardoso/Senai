CREATE SCHEMA `garagem` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE `garagem`.`car` (
  `placa` CHAR(7) NOT NULL COMMENT 'Campo armazena a placa do veículo',
  PRIMARY KEY (`placa`),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC) )
COMMENT = 'Essa tabela armazena dados de veículos';

ALTER TABLE `garagem`.`car` 
ADD COLUMN `fabricante` INT NOT NULL AFTER `placa`;

CREATE TABLE `garagem`.`manufatory` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`codigo`));

ALTER TABLE `garagem`.`car` 
ADD INDEX `fabricante_fk_idx` (`fabricante` ASC);
;
ALTER TABLE `garagem`.`car` 
ADD CONSTRAINT `fabricante_fk`
  FOREIGN KEY (`fabricante`)
  REFERENCES `garagem`.`manufatory` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Honda');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Chevrolet');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Renault');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Chery');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Kia');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('VW');
INSERT INTO `garagem`.`manufatory` (`fabricante`) VALUES ('Hyndai');

INSERT INTO `garagem`.`car` (`placa`, `fabricante`) VALUES ('GFY1B77', '4');
