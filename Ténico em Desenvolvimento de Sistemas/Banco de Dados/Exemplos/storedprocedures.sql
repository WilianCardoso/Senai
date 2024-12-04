-- EXEMPLO PROCEDURE
USE `insightplaces`; 
DROP PROCEDURE IF EXISTS `insightplaces`.`novoAluguel_21`; 
DELIMITER $$ 
USE `insightplaces`$$
CREATE DEFINER=`root`@`LOCALHOST` 
PROCEDURE `novoAluguel_21`() 
BEGIN 
	DECLARE vAluguel VARCHAR(10) DEFAULT 10001; 
	DECLARE vCliente VARCHAR(10) DEFAULT 1002; 
	DECLARE vHospedagem VARCHAR(10) DEFAULT 8635; 
	DECLARE vDataInicio DATE DEFAULT '2023-03-01'; 
	DECLARE vDataFinal DATE DEFAULT '2023-03-05'; 
	DECLARE vPrecoTotal DECIMAL(10,2) DEFAULT 550.23; 
	SELECT vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal;
END$$ 
DELIMITER ;

CALL novoAluguel_21();



-- CRIANDO PARÂMETROS
USE `insightplaces`; 
DROP PROCEDURE IF EXISTS `insightplaces`.`novoAluguel_23`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_23` (vAluguel VARCHAR(10), vCliente VARCHAR(10), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoTotal DECIMAL(10,2)) 
BEGIN 
	INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
END$$ 
DELIMITER ;

CALL novoAluguel_23('10002', '1003', '8635', '2023-03-06', '2023-03-10', 600);
SELECT * from alugueis where aluguel_id = '10002';


-- CALCULANDO DIAS
USE `insightplaces`; 
DROP PROCEDURE IF EXISTS `insightplaces`.`novoAluguel_24`; DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_24` (vAluguel VARCHAR(10), vCliente VARCHAR(10), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vDias INTEGER DEFAULT 0; 
	DECLARE vPrecoTotal DECIMAL(10,2); 
	SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio)); 
	SET vPrecoTotal = vDias * vPrecoUnitario; 
	INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
END$$ 
DELIMITER ;

CALL novoAluguel_24('10004', '1004', '8635', '2023-03-13', '2023-03-16', 40);

SELECT * from alugueis where aluguel_id = '10004';

-- Tratando erros:
USE `insightplaces`; 
DROP PROCEDURE IF EXISTS `insightplaces`.`novoAluguel_25`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_25` (vAluguel VARCHAR(10), vCliente VARCHAR(10), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vDias INTEGER DEFAULT 0; 
	DECLARE vPrecoTotal DECIMAL(10,2); 
	DECLARE vMensagem VARCHAR(100); 
	DECLARE EXIT HANDLER FOR 1452 
	BEGIN 
		SET vMensagem = "Problema de chave estrangeira associado a alguma entidade da base."; 
		SELECT vMensagem; 
	END; 
	SET vDias = (SELECT DATEDIFF(vDataFinal, vDataInicio)); 
	SET vPrecoTotal = vDias * vPrecoUnitario; 
	INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
	SET vMensagem = "Aluguel incluído na base com sucesso."; 
	SELECT vMensagem; 
END$$ 
DELIMITER ;

CALL novoAluguel_25('10007', '10', '8635', '2023-03-13', '2023-03-16', 40);

SELECT *, CAST(aluguel_id AS UNSIGNED) from alugueis order by CAST(aluguel_id AS UNSIGNED)  desc;

delete from alugueis where CAST(aluguel_id AS UNSIGNED)  > 10000;



-- Buscando por um nome para add
USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_31`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_31` (vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vCliente VARCHAR(150); 
	DECLARE vDias INTEGER DEFAULT 0;
	DECLARE VPrecoTotal DECIMAL(10,2); 
	DECLARE vMensagem VARCHAR(100); 
	DECLARE EXIT HANDLER FOR 1452 
	BEGIN 
		SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.'; 
		SELECT vMensagem; 
	END; 
	SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio)); 
	SET vPrecoTotal = vDias * vPrecoUnitario; 
	SELECT cliente_id INTO vCliente FROM clientes WHERE nome = vClienteNome; #Essa linha precisa ser ajustada INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 	
	SET vMensagem = 'Aluguel incluido na base com sucesso.'; 
	SELECT vMensagem; 
END$$ 
DELIMITER; 

CALL novoAluguel_31('10006','Luana Moura','8635','2023-03-26','2023-03-30',40);



-- Procedure para verificar se só tem um cliente com esse nome e adicionar senão aparecer mensagem
-- USANDO CONDICIONAL IF E ELSE
USE `insightplaces`;
DROP procedure IF EXISTS `insightplaces`.`novoAluguel_32`;
DELIMITER $$
USE `insightplaces`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_32`
(vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio  DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vCliente VARCHAR(150);
    DECLARE vDias INTEGER DEFAULT 0;
    DECLARE vNumCliente INTEGER;
    DECLARE vPrecoTotal DECIMAL(10,2);
    DECLARE vMensagem VARCHAR(100);
    DECLARE EXIT HANDLER FOR 1452
    BEGIN
        SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.';
        SELECT vMensagem;
    END;
    SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome);
    IF vNumCliente > 1 THEN
        SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel pelo nome.';
        SELECT vMensagem;
    ELSE
        SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio));
        SET vPrecoTotal = vDias * vPrecoUnitario;
        SELECT cliente_id FROM clientes WHERE nome = vClienteNome;
        INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal);
        SET vMensagem = 'Aluguel incluído na base com sucesso.';
        SELECT vMensagem;
    END IF;
END$$
DELIMITER ;

CALL novoAluguel_32('10007','Júlia Pires','8635','2023-03-30','2023-04-04',40);


-- USANDO CONDICIONAL IF ELSEIF E ELSE
USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_33`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_33` (vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vCliente VARCHAR(150); 
	DECLARE vDias INTEGER DEFAULT 0; 
	DECLARE vNumCliente INTEGER; 
	DECLARE vPrecoTotal DECIMAL(10,2); 
	DECLARE vMensagem VARCHAR(100); 
	DECLARE EXIT HANDLER FOR 1452 
	BEGIN 
		SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.'; 
		SELECT vMensagem; 
	END; 
	SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome); 
	IF vNumCliente > 1 THEN 
		SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel pelo nome.'; 
		SELECT vMensagem; 
	ELSEIF vNumClient = 0 THEN SET 
		vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.'; 
		SELECT vMensagem;
	ELSE 
		SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio)); 
		SET vPrecoTotal = vDias * vPrecoUnitario; 
		SELECT cliente_id FROM clientes WHERE nome = vClienteNome; 
		INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
		SET vMensagem = 'Aluguel incluído na base com sucesso.'; 
		SELECT vMensagem; 
	END IF; 
END$$ 
DELIMITER ;

-- CHAMAR PARA TESTAR COM CLIENTE QUE NÃO EXISTE
CALL novoAluguel_33('10007','Victorino Vila','8635','2023-03-30','2023-04-04',40);


-- USANDO O CASE

USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_34`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_34` (vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vCliente VARCHAR(150); 
	DECLARE vDias INTEGER DEFAULT 0; 
	DECLARE vNumCliente INTEGER; 
	DECLARE vPrecoTotal DECIMAL(10,2); 
	DECLARE vMensagem VARCHAR(100); 
	DECLARE EXIT HANDLER FOR 1452 
	BEGIN 
		SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.'; 
		SELECT vMensagem; 
	END; 
	SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome); 
	CASE vNumCliente 
	WHEN 0 THEN
		SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel pelo nome.'; 
		SELECT vMensagem; 
	WHEN 1 THEN
		SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.'; 
		SELECT vMensagem;
	ELSE 
		SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio)); 
		SET vPrecoTotal = vDias * vPrecoUnitario;
		SELECT cliente_id FROM clientes WHERE nome = vClienteNome; 
		INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
		SET vMensagem = 'Aluguel incluído na base com sucesso.'; 
        SELECT vMensagem; 
	END CASE; 
END$$ 
DELIMITER ;

CALL novoAluguel_34('10007','Luana Moura','8635','2023-03-30','2023-04-04',40);


-- CASE CONDICIONAL
USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_35`; 
DELIMITER $$ 
USE `insightplaces`$$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_35` (vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE, vDataFinal DATE, vPrecoUnitario DECIMAL(10,2)) 
BEGIN 
	DECLARE vCliente VARCHAR(150); 
	DECLARE vDias INTEGER DEFAULT 0; 
	DECLARE vNumCliente INTEGER; 
	DECLARE vPrecoTotal DECIMAL(10,2); 
	DECLARE vMensagem VARCHAR(100); 
	DECLARE EXIT HANDLER FOR 1452 
	BEGIN 
		SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.'; 
		SELECT vMensagem; 
	END; 
	SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome); 
	CASE
	WHEN vNumCliente = 0 THEN
		SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel pelo nome.'; 
	SELECT vMensagem; 
WHEN vNumCliente = 1 THEN
	SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio)); 
	SET vPrecoTotal = vDias * vPrecoUnitario; 
	SELECT cliente_id FROM clientes WHERE nome = vClienteNome; 
	INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal); 
	SET vMensagem = 'Aluguel incluído na base com sucesso.'; 
		SELECT vMensagem;
	WHEN vNumCliente > 1 THEN
	SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.'; 
	SELECT vMensagem;
	END CASE; 
END$$ 
DELIMITER ;

CALL novoAluguel_35('10007','Victorino Vila','8635','2023-03-30','2023-04-04',40);
CALL novoAluguel_35('10007','Júlia Pires','8635','2023-03-30','2023-04-04',40);
CALL novoAluguel_35('10007','Luana Moura','8635','2023-03-30','2023-04-04',40);

DELETE FROM alugueis WHERE aluguel_id = 1007;


-- Alterando a data final para quantidade de dias
SELECT '2023-01-01' + INTERVAL 5 DAY;

USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_41`; 
DELIMITER $$ 

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_41`(vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE,
vDias INTEGER, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vCliente VARCHAR(10);
    DECLARE vDataFinal DATE;
    DECLARE vNumCliente INTEGER;
    DECLARE VPrecoTotal DECIMAL(10,2);
    DECLARE vMensagem VARCHAR(100);
    DECLARE EXIT HANDLER FOR 1452
    BEGIN
        SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.';
        SELECT vMensagem;
    END;
    SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome);
    CASE 
    WHEN vNumCliente = 0 THEN
        SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
        SELECT vMensagem;
    WHEN vNumCliente = 1 THEN
        -- SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio));
        SET vDataFinal = (SELECT vDataInicio + INTERVAL vDias DAY) ;
        SET vPrecoTotal = vDias * vPrecoUnitario;
        SELECT cliente_id INTO vCliente FROM clientes WHERE nome = vClienteNome;
        INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, 
        vDataFinal, vPrecoTotal);
        SET vMensagem = 'Aluguel incluido na base com sucesso.';
        SELECT vMensagem;
    WHEN vNumCliente > 1 THEN
       SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
       SELECT vMensagem;
    END CASE;
END $$
DELIMITER ;

CALL novoAluguel_41('10008', 'Rafael Peixoto', '3635', '2023-04-05',5,40);

SELECT * FROM alugueis WHERE aluguel_id = '10008';

-- Pedido do maketing para implementar um procedure que não conte o fim de semana como dia de hospedagem

USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`novoAluguel_42`; 
DELIMITER $$ 

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_42`(vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE,
vDias INTEGER, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vCliente VARCHAR(10);
    DECLARE vContador INTEGER;
    DECLARE vDiaSemana INTEGER;
    DECLARE vDataFinal DATE;
    DECLARE vNumCliente INTEGER;
    DECLARE VPrecoTotal DECIMAL(10,2);
    DECLARE vMensagem VARCHAR(100);
    DECLARE EXIT HANDLER FOR 1452
    BEGIN
        SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.';
        SELECT vMensagem;
    END;
    SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome);
    CASE 
    WHEN vNumCliente = 0 THEN
        SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
        SELECT vMensagem;
    WHEN vNumCliente = 1 THEN
        -- SET vDias = (SELECT DATEDIFF (vDataFinal, vDataInicio));
        -- SET vDataFinal = (SELECT vDataInicio + INTERVAL vDias DAY) ;
        SET vContador = 1;
        SET vDataFinal = vDataInicio;
        WHILE vContador < vDias
        DO
            SET vDiaSemana = (SELECT DAYOFWEEK(STR_TO_DATE(vDataFinal,'%Y-%m-%d')));
            IF (vDiaSemana <> 7 AND vDiaSemana <> 1) THEN
                SET vContador = vContador + 1;
            END IF;
            SET vDataFinal = (SELECT vDataFinal + INTERVAL 1 DAY) ;
        END WHILE;
        SET vPrecoTotal = vDias * vPrecoUnitario;
        SELECT cliente_id INTO vCliente FROM clientes WHERE nome = vClienteNome;
        INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, 
        vDataFinal, vPrecoTotal);
        SET vMensagem = 'Aluguel incluido na base com sucesso.';
        SELECT vMensagem;
    WHEN vNumCliente > 1 THEN
       SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
       SELECT vMensagem;
    END CASE;
END $$
DELIMITER ;	

CALL novoAluguel_42('10010','Gabriela Pires', '8635', '2023-04-12',5,40);

SELECT * FROM alugueis WHERE aluguel_id = '10010';

-- Procedure ficando grande pode ser feito divisão e usar a chamda 

USE `insightplaces`; DROP procedure IF EXISTS `insightplaces`.`calculaDataFinal_43`; 
DELIMITER $$ 

CREATE PROCEDURE `calculaDataFinal_43` (vDataInicio DATE, INOUT vDataFinal DATE, vDias INTEGER)
BEGIN
DECLARE vContador INTEGER;
DECLARE vDiaSemana INTEGER;
SET vContador = 1;
SET vDataFinal = vDataInicio;
WHILE vContador < vDias
DO
        SET vDiaSemana = (SELECT DAYOFWEEK(STR_TO_DATE(vDataFinal, `%Y-%m-%d`)));
        IF (vDiaSemana <> 7 AND vDiaSemana <> 1) THEN
            SET vContador = vContador + 1;
        END IF;
        SET vDataFinal = (SELECT vDataFinal + INTERVAL 1 DAY);
END WHILE;
END $$
DELIMITER ;	

-- mudamos o código para chamar a procedure criada acima

USE `insightplaces`;
DROP procedure IF EXISTS `insightplaces`. `novoAluguel_43`;
DELIMITER $$
USE `insightplaces` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_43`
(vAluguel VARCHAR(10), vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE, vDias INTEGER, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vCliente VARCHAR(10);
    DECLARE vDataFinal DATE;
    DECLARE vNumCliente INTEGER;
    DECLARE vPrecoTotal DECIMAL (10,2);
    DECLARE vMensagem VARCHAR(100);
    DECLARE EXIT HANDLER FOR 1452
    BEGIN
        SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.';
        SELECT vMensagem;
    END;
    SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = ClienteNome);
    CASE
    WHEN vNumCliente > 1 THEN
        SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
        SELECT vMensagem;
    WHEN vNumCliente > 1 THEN

        CALL calculaDataFinal_43 (vDataInicio, vDataFinal, vDias);
        SET vPrecoTotal = vDias * vPrecoUnitario;
        SELECT cliente_id INTO vCliente FROM clientes WHERE nome= vClienteNome;
        INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, vDataFinal, vPrecoTotal);
        SET VMensagem = `Aluguel incluido na base com sucesso.`;
        SELECT vMensagem;
    WHEN vNumCliente > 1 THEN
        SET vMensagem = `Este cliente não pode ser usado para incluir o aluguel porque não existe.`;
        SELECT vMensagem;
    END CASE;
END$$
DELIMITER ;

-- chamamos
CALL novoAluguel_43 ('10011', 'Livia Fogaça', '8635', '2023-04-20',10,40);

-- verificamos
SELECT * FROM alugueis WHERE aluguel_id = '10011';





-- Criar referência para adicionar ID autmaticamente

-- assim pega como string e como número para usar o MAX
SELECT aluguel_id, CAST(aluguel_id AS UNSIGNED) FROM alugueis;

-- mostrando diferença de resultados
SELECT MAX(aluguel_id), MAX(CAST(aluguel_id AS UNSIGNED)) FROM alugueis;

-- criar procedure com esse código para adicionar automaticamente o vAluguel

USE `insightplaces`;
DROP procedure IF EXISTS `insightplaces`. `novoAluguel_44`;
DELIMITER $$
USE `insightplaces` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `novoAluguel_44`(vClienteNome VARCHAR(150), vHospedagem VARCHAR(10), vDataInicio DATE,
vDias INTEGER, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vAluguel VARCHAR(10);
    DECLARE vCliente VARCHAR(10);
    DECLARE vDataFinal DATE;
    DECLARE vNumCliente INTEGER;
    DECLARE VPrecoTotal DECIMAL(10,2);
    DECLARE vMensagem VARCHAR(100);
    DECLARE EXIT HANDLER FOR 1452
    BEGIN
        SET vMensagem = 'Problema de chave estrangeira associado a alguma entidade da base.';
        SELECT vMensagem;
    END;
    SET vNumCliente = (SELECT COUNT(*) FROM clientes WHERE nome = vClienteNome);
    CASE 
    WHEN vNumCliente = 0 THEN
        SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
        SELECT vMensagem;
    WHEN vNumCliente = 1 THEN
        SELECT CAST(MAX(CAST(aluguel_id AS UNSIGNED)) + 1 AS CHAR) INTO vAluguel FROM alugueis;
        CALL calculaDataFinal_43 (vDataInicio, vDataFinal, vDias);
        SET vPrecoTotal = vDias * vPrecoUnitario;
        SELECT cliente_id INTO vCliente FROM clientes WHERE nome = vClienteNome;
        INSERT INTO alugueis VALUES (vAluguel, vCliente, vHospedagem, vDataInicio, 
        vDataFinal, vPrecoTotal);
        SET vMensagem = CONCAT('Aluguel incluido na base com sucesso. - ID ' , vAluguel) ;
        SELECT vMensagem;
    WHEN vNumCliente > 1 THEN
       SET vMensagem = 'Este cliente não pode ser usado para incluir o aluguel porque não existe.';
       SELECT vMensagem;
    END CASE;
END$$
DELIMITER ;

-- mudar código para deletar;
DELETE FROM alugueis WHERE aluguel_id = '10012';

CALL novoAluguel_44('Livia Fogaça', '8635', '2023-05-15', 5, 45);






-- Usando tabelas temporárias para adicionar lista de clientes na mesma hospedagem

USE `insightplaces`;
DROP procedure IF EXISTS `insightplaces`. `inclui_usuarios_lista_52`;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `inclui_usuarios_lista_52`(lista VARCHAR(255))
BEGIN
    DECLARE nome VARCHAR(255);
    DECLARE restante VARCHAR(255);
    DECLARE pos INTEGER;
    SET restante = lista;
    WHILE INSTR(restante,',') > 0 DO
        SET pos = INSTR(restante,',');
        SET nome = LEFT(restante, pos - 1);
        INSERT INTO temp_nomes VALUES (nome);
        SET restante = SUBSTRING(restante, pos + 1);
    END WHILE;
    IF TRIM(restante) <> '' THEN
       INSERT INTO temp_nomes VALUES (TRIM(restante));
    END IF;
END$$
DELIMITER ;

-- A stored procedure inclui_usuarios_lista_52 realiza as seguintes operações:

-- Definição da Procedure e Parâmetro: Inicia a procedure que recebe uma lista de nomes separados por vírgula.
-- Declaração de Variáveis: Declara variáveis para armazenar o nome atual, a parte restante da lista e a posição da próxima vírgula.
-- Inicialização da Variável restante: Atribui a lista completa à variável restante para iniciar o processamento.
-- Loop WHILE: Entra em um loop enquanto houver uma vírgula na string restante.
-- Determinação da Posição da Vírgula: Usa INSTR para encontrar a posição da próxima vírgula em restante.
-- Extração do Nome: Extrai o nome atual usando LEFT até a vírgula encontrada.
-- Inserção do Nome: Insere o nome extraído na tabela temp_nomes.
-- Atualização da Variável restante: Remove o nome inserido de restante usando SUBSTRING, preparando para a próxima iteração.
-- Tratamento do Último Nome: Após o loop, verifica se restante contém um nome não seguido por vírgula e o insere na tabela.
-- Essa procedure permite inserir múltiplos nomes em uma tabela temporária a partir de uma string única.

USE `insightplaces`;
DROP procedure IF EXISTS `insightplaces`. `novosAlugueis_55`;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `novosAlugueis_55`(lista VARCHAR(255),
vHospedagem VARCHAR(10), vDataInicio DATE,
vDias INTEGER, vPrecoUnitario DECIMAL(10,2))
BEGIN
    DECLARE vClienteNome VARCHAR(150);
    DECLARE fimCursor INTEGER DEFAULT 0;
    DECLARE vnome VARCHAR(255);
    DECLARE cursor1 CURSOR FOR SELECT nome FROM temp_nomes;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fimCursor = 1;
    DROP TEMPORARY TABLE IF EXISTS temp_nomes;
    CREATE TEMPORARY TABLE temp_nomes (nome VARCHAR(255));
    CALL inclui_usuarios_lista_52(lista);
    OPEN cursor1;
    FETCH cursor1 INTO vnome;
    WHILE fimCursor = 0 DO
        SET vClienteNome = vnome;
        CALL novoAluguel_44 (vClienteNome, vHospedagem, vDataInicio, vDias, vPrecoUnitario);
        FETCH cursor1 INTO vnome;
    END WHILE;
    CLOSE cursor1;
    DROP TEMPORARY TABLE IF EXISTS temp_nomes;
END$$
DELIMITER ;

-- A procedure novosAlugueis_55 executa os seguintes passos para incluir múltiplos aluguéis:

-- Definição da Procedure e Parâmetros: Define a procedure e seus parâmetros, incluindo uma lista de nomes, informações da hospedagem, 
-- data de início, número de dias e preço unitário.

-- Declaração de Variáveis: Declara variáveis para armazenar o nome do cliente, controle do cursor e nome temporário.

-- Cursor e Handler: Estabelece um cursor para iterar sobre os nomes na tabela temporária temp_nomes e um handler para encerrar o 
-- loop quando todos os nomes forem processados.

-- Gerenciamento da Tabela Temporária: Remove e recria a tabela temporária temp_nomes para garantir que está vazia antes de inserir 
-- novos nomes.

-- Inclusão de Nomes na Tabela Temporária: Utiliza outra procedure para incluir os nomes da lista na tabela temporária.

-- Loop de Processamento: Abre o cursor, busca cada nome e, para cada um, chama a procedure novoAluguel_44 para inserir o aluguel, 
-- continuando até que todos os nomes sejam processados.

-- Fechamento e Limpeza: Encerra o cursor e elimina a tabela temporária após o uso.




