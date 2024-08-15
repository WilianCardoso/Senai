CREATE SCHEMA `garagem1` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE `garagem1`.`car` (
  `placa` CHAR(7) NOT NULL,
  `fabricante` INT(11) NULL,
  `ano` INT(2) NULL,
  `cor` INT(2) NULL,
  `modelo` INT(2) NULL,
  `opcional` INT(2) NULL,
  `opcional_itens` INT(2) NULL,
  PRIMARY KEY (`placa`),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC));
  
  CREATE TABLE `garagem1`.`ano` (
  `idano` INT NOT NULL AUTO_INCREMENT,
  `ano` INT(4) NOT NULL,
  PRIMARY KEY (`idano`));
  
INSERT INTO `garagem1`.`ano` (`ano`) VALUES ('2023');
INSERT INTO `garagem1`.`ano` (`ano`) VALUES ('2022');
INSERT INTO `garagem1`.`ano` (`ano`) VALUES ('2024');
INSERT INTO `garagem1`.`ano` (`ano`) VALUES ('2025');
  
  CREATE TABLE `garagem1`.`cor` (
  `idcor` INT NOT NULL AUTO_INCREMENT,
  `cor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcor`));
  
INSERT INTO `garagem1`.`cor` (`cor`) VALUES ('preto');
INSERT INTO `garagem1`.`cor` (`cor`) VALUES ('branco');
INSERT INTO `garagem1`.`cor` (`cor`) VALUES ('azul');
INSERT INTO `garagem1`.`cor` (`cor`) VALUES ('vermelho');
INSERT INTO `garagem1`.`cor` (`cor`) VALUES ('rosa');

  
  CREATE TABLE `garagem1`.`manufactory` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(50) NOT NULL,
  `modelo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`codigo`));
  
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('HONDA');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('CHEVROLET');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('FIAT');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('RENAULT');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('CHERY');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('KIA');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('HYUNDAI');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('HONDA');
INSERT INTO `garagem1`.`manufactory` (`fabricante`) VALUES ('VW');

UPDATE `garagem1`.`manufactory` SET `modelo` = 'Civic' WHERE (`codigo` = '1');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Astra' WHERE (`codigo` = '2');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Uno' WHERE (`codigo` = '3');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Fluence' WHERE (`codigo` = '4');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Tiggo' WHERE (`codigo` = '5');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Cerato' WHERE (`codigo` = '6');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Azera' WHERE (`codigo` = '7');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Civic' WHERE (`codigo` = '8');
UPDATE `garagem1`.`manufactory` SET `modelo` = 'Golf' WHERE (`codigo` = '9');

CREATE TABLE `garagem1`.`opcionais` (
  `idopcionais` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `opc_itens` INT(2) NOT NULL,
  PRIMARY KEY (`idopcionais`));
  
  CREATE TABLE `garagem1`.`opcionais_itens` (
  `idopcionais_itens` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT(11) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idopcionais_itens`));

ALTER TABLE `garagem1`.`opcionais` 
ADD INDEX `opcionaisItens_idx` (`opc_itens` ASC);
;
ALTER TABLE `garagem1`.`opcionais` 
ADD CONSTRAINT `opcionaisItens`
  FOREIGN KEY (`opc_itens`)
  REFERENCES `garagem1`.`opcionais_itens` (`idopcionais_itens`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `garagem1`.`car` 
ADD INDEX `opcional_fk_idx` (`opcional` ASC);
;
ALTER TABLE `garagem1`.`car` 
ADD CONSTRAINT `opcional_fk`
  FOREIGN KEY (`opcional`)
  REFERENCES `garagem1`.`opcionais` (`idopcionais`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `garagem1`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `level_id` INT(2) NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `status` INT(1) NOT NULL,
  PRIMARY KEY (`iduser`));
  
  CREATE TABLE `garagem1`.`level` (
  `idlevel` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `id_level_itens` INT(2) NULL,
  `status` INT(1) NOT NULL,
  PRIMARY KEY (`idlevel`));
  
  CREATE TABLE `garagem1`.`level_itens` (
  `idlevel_itens` INT NOT NULL AUTO_INCREMENT,
  `codigo2` INT(2) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `status` INT(1) NOT NULL,
  PRIMARY KEY (`idlevel_itens`, `codigo2`));
  
  ALTER TABLE `garagem1`.`level` 
ADD INDEX `levelItens_fk_idx` (`id_level_itens` ASC);
;
ALTER TABLE `garagem1`.`level` 
ADD CONSTRAINT `levelItens_fk`
  FOREIGN KEY (`id_level_itens`)
  REFERENCES `garagem1`.`level_itens` (`idlevel_itens`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `garagem1`.`user` 
ADD INDEX `levelId_fk_idx` (`level_id` ASC);
;
ALTER TABLE `garagem1`.`user` 
ADD CONSTRAINT `levelId_fk`
  FOREIGN KEY (`level_id`)
  REFERENCES `garagem1`.`level` (`idlevel`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  