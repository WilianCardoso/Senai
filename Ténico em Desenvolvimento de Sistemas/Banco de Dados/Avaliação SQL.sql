-- ---------------------atividades----------------------------

-- Questão 1
select *
from departamento
where id_departamento = 30;

-- Questão 2
select nm_empregado, funcao, id_departamento
from empregado
where funcao = "analista";

-- Questão 3
select nm_empregado, salario, comissao 
from empregado 
where  comissao is not null;

-- Questão 4
select nm_empregado, funcao, DATA_CONTRATACAO, salario, ID_DEPARTAMENTO 
from empregado 
where  ID_DEPARTAMENTO=20 and salario >1000;

-- Questão 5
select nm_empregado as "Nome", funcao Função, salario "Salário", 
comissao Comissão, DATA_CONTRATACAO "Data de Contratação", lider Líder, 
ID_DEPARTAMENTO Departamento, ID_EMPREGADO Cadastro  
from empregado
where funcao = "gerente";

-- Questão 6
select *
from empregado
where NM_EMPREGADO like '%A%';

-- Questão 7
select nm_empregado, ID_DEPARTAMENTO 
from empregado 
where ID_DEPARTAMENTO in (10,30);

-- Questão 8
select nm_empregado,DATA_CONTRATACAO 
from empregado 
where DATA_CONTRATACAO like "1982%";

-- Questão 9
select * 
from empregado 
where comissao >= 500 order by NM_EMPREGADO asc;

-- Questão 10

select *
from empregado
where salario < 1300 order by SALARIO desc;