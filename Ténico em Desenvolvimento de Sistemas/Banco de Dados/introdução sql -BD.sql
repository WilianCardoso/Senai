
create table grade_salarial(
menor_salario decimal (10,2) not null,
maior_salario decimal (10,2) not null,
constraint grade_salarial_id_grade_salarial_pk
primary key (id_grade_salarial)
);

create table departamento(
id_departamento int,
nm_departamento varchar (30) not null,
localizacao varchar(20) not null,
constraint id_departamento_pk
primary key (id_departamento)
);


create table empregado(
id_empregado int,
nm_empregado varchar (45) not null,
funcao varchar(45) not null,
data_contratacao date not null,
salario decimal (10,2) not null,
comissao decimal (10,2),
id_departamento int not null,
lider int,
constraint empregado_id_empregado_pk
primary key empregado(id_empregado),
constraint empregado_lider_fk
foreign key (lider) references empregado(id_empregado),
constraint empregado_id_empregado_fk
foreign key (id_departamento) references departamento(id_departamento)
);

#preencher a tabela - emxemplo com dois campos inseridos
insert into departamento (id_departamento, nm_departamento, localizacao)
value (50, 'Desenvolvimento', 'Detroide'); 

insert into departamento value(60, 'Web-design', 'Timbo');
 
insert into departamento value(70, 'Suporte', 'Detroit');

#exemplo sem passar os parametros
insert into departamento value (80, 'HR', 'IndaHell');

insert into empregado values (1, "Hermano","Professor", "2014-03-02", '1000', null, 60, null);
insert into empregado values (2, "Gerson","Professor", "2019-05-01", '1500', null, 60, null);
insert into empregado values (3, "Gustavo","Professor", "2021-10-01", '1500', null, 70, 1);

insert into empregado (id_empregado, nm_empregado, funcao, data_contratacao, salario, comissao, id_departamento) values (4, "Sabrina","Atentimento", "2023-12-01", '400', 100, 60);

update empregado set nm_empregado = "Hermano Roepke" where id_empregado = 1;
#visualisar a tabela, * - tudo!!!
select * from empregado;
    
desc empregado;
desc departamento;
desc grade_salarial;

alter table empregado
	add constraint empregado_id_empregado_pk
    primary key(id_empregado);
    
    #Alterar chave primaria de empregado
alter table empregado add constraint empregado_id_empregado_pk
primary key(id_empregado);
    
    #add chave primaria no departamento
alter table departamento
		add	constraint departamento_id_departamento_pk
        primary key (id_departamento);
        
    #add chave estrangeira no empregado
alter table empregado
		add constraint empregado
        foreign key (id_departamento)
        references departamento(id_departamento);
        
     #colocar chave estrangeira como not null
 alter table empregado
	modify column lider int not null;
    
    #add chave estrangeira no empregado
    alter table empregado
		add constraint lider
        foreign key (lider)
        references empregado(id_empregado);
        