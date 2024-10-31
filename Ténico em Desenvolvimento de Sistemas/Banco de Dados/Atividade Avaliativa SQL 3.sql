-- Questão 1
Select AVG(salario) Media, SUM(salario) SOMA,
	min(salario)'Menor Salario',
    max(salario)'Maior Salario'
FROM empregado
WHERE ID_EMPREGADO;

-- Questão 2
Select funcao Função,AVG(salario) Media, SUM(salario) SOMA,
	min(salario)'Menor Salario',
    max(salario)'Maior Salario'
FROM empregado 
group by funcao;

-- Questão 3
Select funcao Função, count(funcao)
FROM empregado 
group by funcao;

-- Questão 4
Select funcao, count(funcao)
FROM empregado 
WHERE funcao like 'gerente';

-- Questão 5
Select d.NM_DEPARTAMENTO, d.LOCALIZACAO, count(e.funcao), AVG(e.SALARIO)
FROM empregado e, departamento d 
where d.id_departamento = e.id_departamento
GROUP BY d.id_departamento;

-- Questão 6
Select d.NM_DEPARTAMENTO, AVG(e.SALARIO)
FROM empregado e right join departamento d on 
	e.id_departamento = d.id_departamento
GROUP BY nm_departamento
HAVING	AVG(coalesce(salario,0)) > 2000;

-- Questão 7
Select d.NM_DEPARTAMENTO, d.LOCALIZACAO, count(e.SALARIO)
FROM empregado e right join departamento d on
e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
group by d.NM_DEPARTAMENTO
HAVING count(e.ID_EMPREGADO) >= 5;

-- Questão 8
SELECT l.nm_empregado, count(e.lider)
from empregado e, empregado l 
WHERE e.lider = l.id_empregado
group by  e.lider;

-- Questão 9
Select d.NM_DEPARTAMENTO, coalesce(min(e.SALARIO),0) Menor_Salario, 
       coalesce(max(e.SALARIO),0) Maior_Salario
FROM departamento d, empregado e
WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
group by d.NM_DEPARTAMENTO;

-- Questão 10
SELECT d.nm_departamento, count(e.id_empregado), g.ID_GRADE_SALARIAL
FROM  grade_salarial g,empregado e, departamento d
WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO and e.salario between g.MENOR_SALARIO and g.MAIOR_SALARIO
group by g.id_grade_salarial, d.NM_DEPARTAMENTO order by d.NM_DEPARTAMENTO; 




