create table empregado(
id_empregado int,
nm_empregado varchar (45),
funcao varchar(45),
data_contratacao date,
salario decimal (10,2),
comissao decimal (10,2),
id_departamento int,
lider int
);

create table grade_salarial(
menor_salario decimal (10,2),
maior_salario decimal (10,2)
);

create table departamento(
id_departamento int,
nm_departamento varchar (30),
localizacao varchar(20)
);

create table departamento30
As
	select id_empregado, nm_empregado, salario,
    data_contratacao
    from empregado
    where id_departamento = 30
;

drop table departamento30;

alter table departamento30
	add tarefa varchar(9);
    
alter table departamento30
	modify tarefa varchar(15);
    
alter table departamento30
	drop tarefa;
    
desc departamento30;
desc empregado;
desc departamento;
desc grade_salarial;