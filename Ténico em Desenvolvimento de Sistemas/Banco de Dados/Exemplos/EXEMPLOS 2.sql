-- Criação do esquema
CREATE SCHEMA db_gestao_pecas;

USE db_gestao_pecas;

-- Tabela de usuários
CREATE TABLE usuario (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario BOOLEAN NOT NULL, -- TRUE para administrador, FALSE para funcionário
    PRIMARY KEY (ID)
);

-- Tabela de peças
CREATE TABLE peca (
    id INTEGER NOT NULL AUTO_INCREMENT,
    codigo INTEGER NOT NULL UNIQUE,
    nome VARCHAR(45) NOT NULL,
    qtd_estoque INTEGER NOT NULL CHECK (qtd_estoque >= 0),
    preco DOUBLE NOT NULL CHECK (preco >= 0),
    PRIMARY KEY (id)
);

-- Tabela de fornecedores
CREATE TABLE fornecedor (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj_cpf VARCHAR(18) NOT NULL UNIQUE, 
    telefone VARCHAR(15) NOT NULL, 
    email VARCHAR(100),
    endereco VARCHAR(255),
    PRIMARY KEY (id)
);

-- Tabela de histórico de movimentações
CREATE TABLE hist_mov (
    id INTEGER NOT NULL AUTO_INCREMENT,
    tipo_movimentacao ENUM('entrada', 'saida') NOT NULL, 
    qtd INTEGER NOT NULL CHECK (qtd > 0),
    data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    peca_id INTEGER NOT NULL, 
    fornecedor_id INTEGER,
    usuario_id INTEGER, 
    PRIMARY KEY (id),
    FOREIGN KEY (peca_id) REFERENCES peca(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Dados iniciais
INSERT INTO usuario (nome, senha, tipo_usuario) VALUES ('admin', '123', 1);
INSERT INTO peca (codigo, nome, qtd_estoque, preco) VALUES (101, 'Parafuso', 50, 0.10);

-- Criação da trigger para atualizar o estoque
DELIMITER $$

CREATE TRIGGER atualiza_estoque
AFTER INSERT ON hist_mov
FOR EACH ROW
BEGIN
    IF NEW.tipo_movimentacao = 'entrada' THEN
        -- Aumenta o estoque para movimentação de entrada
        UPDATE peca
        SET qtd_estoque = qtd_estoque + NEW.qtd
        WHERE id = NEW.peca_id;
    ELSEIF NEW.tipo_movimentacao = 'saida' THEN
        -- Reduz o estoque para movimentação de saída
        UPDATE peca
        SET qtd_estoque = qtd_estoque - NEW.qtd
        WHERE id = NEW.peca_id;

        -- Validação: impede estoque negativo
        IF (SELECT qtd_estoque FROM peca WHERE id = NEW.peca_id) < 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Erro: Estoque insuficiente para saída!';
        END IF;
    END IF;
END;
$$

DELIMITER ;

-- Movimentação de entrada (estoque aumenta):
INSERT INTO hist_mov (tipo_movimentacao, qtd, peca_id, usuario_id) 
VALUES ('entrada', 20, 1, 1);

-- Movimentação de saída válida (estoque diminui):
INSERT INTO hist_mov (tipo_movimentacao, qtd, peca_id, usuario_id) 
VALUES ('saida', 10, 1, 1);

-- Movimentação de saída inválida (estoque insuficiente):
INSERT INTO hist_mov (tipo_movimentacao, qtd, peca_id, usuario_id) 
VALUES ('saida', 100, 1, 1);