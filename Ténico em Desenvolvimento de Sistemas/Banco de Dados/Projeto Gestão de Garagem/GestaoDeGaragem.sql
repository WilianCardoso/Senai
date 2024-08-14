CREATE SCHEMA `garagem` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE `car` (
  `placa` char(7) NOT NULL COMMENT 'Campo armazena a placa do veículo',
  `fabricante` int(11) NOT NULL,
  `ano` int(2) NOT NULL,
  `cor` int(2) NOT NULL,
  `modelo` int(2) NOT NULL,
  `opcional` int(2) NOT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  KEY `fabricante_fk` (`fabricante`),
  KEY `fk_ano_idx` (`ano`),
  KEY `fk_cor_idx` (`cor`),
  KEY `fk_modelo_idx` (`modelo`),
  CONSTRAINT `fabricante_fk` FOREIGN KEY (`fabricante`) REFERENCES `manufatory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ano` FOREIGN KEY (`ano`) REFERENCES `ano` (`idano`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cor` FOREIGN KEY (`cor`) REFERENCES `cor` (`idcor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_modelo` FOREIGN KEY (`modelo`) REFERENCES `manufatory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Essa tabela armazena dados de veículos';

CREATE TABLE `ano` (
  `idano` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(4) NOT NULL,
  PRIMARY KEY (`idano`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `cor` (
  `idcor` int(11) NOT NULL AUTO_INCREMENT,
  `cor` varchar(30) NOT NULL,
  PRIMARY KEY (`idcor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `manufatory` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(50) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
