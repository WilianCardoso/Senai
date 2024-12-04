-- 1) Selecionar os nomes dos empregados cujo salário é superior à média salarial de todos os empregados.
	SELECT nm_empregado, SALARIO
    FROM EMPREGADO
    WHERE SALARIO>(SELECT AVG(SALARIO) FROM EMPREGADO);	
    
-- 2) Selecionar os empregados cujo salário está acima da média salarial do seu próprio departamento.
	SELECT E.NM_EMPREGADO, E.SALARIO
    FROM EMPREGADO E
    WHERE SALARIO>(SELECT AVG(SALARIO) FROM EMPREGADO D WHERE E.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO);
    
-- 3) Selecionar todas as funções distintas desempenhadas pelos empregados, sem repetições
	SELECT  DISTINCT FUNCAO
    FROM EMPREGADO
    WHERE ID_EMPREGADO;
    
-- 4) Selecionar o nome do empregado e a quantidade de anos trabalhados na empresa.
	SELECT NM_EMPREGADO, (2024 - YEAR (DATA_CONTRATACAO)) 'TEMPO'
    FROM EMPREGADO
    WHERE ID_EMPREGADO;
    
-- 5) Selecionar o nome do departamento e o total de dias de trabalho de todos os funcionários do departamento.
	SELECT D.NM_DEPARTAMENTO, COALESCE(SUM(TIMESTAMPDIFF(DAY, E.DATA_CONTRATACAO, CURDATE())),0) 'TEMPO'
    FROM EMPREGADO E RIGHT JOIN DEPARTAMENTO D
    ON E.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO
    GROUP BY NM_DEPARTAMENTO;
    
-- 6) Selecionar o nome do empregado, o nome do líder, a data de contratação do empregado e do líder (no formato dd/mm/yyyy), 
 -- e a diferença entre as datas de contratação do líder e do empregado em anos, meses e dias.
	SELECT E.NM_EMPREGADO EMPREGADO, 
    E.DATA_CONTRATACAO CONTRATAÇÃO_EMPREGADO, 
	L.NM_EMPREGADO LIDER,
    L.DATA_CONTRATACAO CONTRATAÇÃO_LÍDER,
    ABS(TIMESTAMPDIFF(YEAR,E.DATA_CONTRATACAO, L.DATA_CONTRATACAO)) DIFERENÇA_EM_ANOS,
    ABS(TIMESTAMPDIFF(MONTH,E.DATA_CONTRATACAO, L.DATA_CONTRATACAO))%12 DIFERENÇA_EM_DIAS,
    ABS(DATEDIFF(E.DATA_CONTRATACAO, L.DATA_CONTRATACAO))%30 DIFERENÇA_EM_DIAS
    FROM empregado e, empregado l where e.lider = l.ID_EMPREGADO;
    
 -- 7) Selecionar uma string com as duas primeiras letras do nome do empregado, seguidas pelo caractere “*” juntamente com o nome do departamento, 
 -- função, e o nome do líder abreviado para as três primeiras letras seguidas do caractere “*”.
	
 -- 8) Selecionar o nome do empregado, o nome do departamento e a classificação da grade salarial de cada empregado,
 -- substituindo o ID_GRADE_SALARIAL por descrições textuais: 1 – Ruim, 2 – Abaixo da média, 3 – Mediano, 4 – Acima da média, 5 – Excelente
 
 -- 9) Recuperar o nome de cada departamento e a porcentagem de participação no pagamento total da empresa, 
 -- considerando a soma dos salários e comissões dos empregados de cada departamento.
 
 -- 10) Selecionar os empregados que são líderes, juntamente com a quantidade de subordinados, a data de contratação do líder (no formato dd/mm/yyyy),
 -- e a soma dos salários e comissões de todos os seus subordinados, utilizando apelidos nas colunas para identificação.