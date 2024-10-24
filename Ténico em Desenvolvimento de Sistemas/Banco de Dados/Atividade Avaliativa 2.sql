-- Questão 1
SELECT e.nm_empregado, e.id_empregado, d.nm_departamento 
FROM empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO;

-- Questão 2
Select e.nm_empregado,e.funcao, e.salario, d.nm_departamento, d.localizacao  
from empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and d.LOCALIZACAO like 'new york';

-- Questão 3
Select e.nm_empregado, e.comissao, d.nm_departamento, d.localizacao  
from empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and e.ID_EMPREGADO and e.comissao is not null;

-- Questão 4
Select e.nm_empregado, e.funcao, e.salario, d.nm_departamento, g.id_grade_salarial   
from empregado e, departamento d, grade_salarial g
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and e.salario between g.menor_salario and g.maior_salario; 

-- Questão 5
SELECT e.nm_empregado, e.id_empregado, l.nm_empregado LIDER, l.id_empregado id_lider
FROM empregado e  RIGHT JOIN empregado l on(e.ID_EMPREGADO = l.ID_EMPREGADO);

-- Questão 6
select e.nm_empregado, d.nm_departamento, g.id_grade_salarial
from empregado e, departamento d, grade_salarial g
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and e.salario between g.menor_salario and g.maior_salario; 

-- Questão 7
select e.nm_empregado, e.salario,e.DATA_CONTRATACAO, d.NM_DEPARTAMENTO
from empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and d.nm_departamento like "pesquisa e desenvolvimento" order by e.SALARIO desc;

-- Questão 8
select e.*, d.localizacao
from empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and d.LOCALIZACAO like 'chicago' and e.comissao is null;

-- Questão 9
select e.nm_empregado, e.id_empregado, d.id_departamento, d.nm_departamento, e.salario
from empregado e, departamento d
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and e.salario >=1500 and e.salario <=3000;

-- Questão 10
select e.nm_empregado, e.salario, e.data_contratacao, d.id_departamento, l.nm_empregado NM_Lider, l.data_contratacao Data_Contratacao_Lider, l.salario salario_lider
from empregado e, departamento d, empregado l
where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO;


