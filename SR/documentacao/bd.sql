drop database if exists SR;
create database SR;
use SR;

create table funcoes(
	id_funcao integer not null auto_increment,
	funcao varchar(15) not null,
	primary key (id_funcao)
);

create table funcionarios(
    id_funcao integer not null,
    id_funcionario integer not null auto_increment, 
	nome varchar(35) not null,
    valorHora decimal(6,2) not null,
    constraint fk_funcao foreign key (id_funcao)
    references funcoes(id_funcao),
    primary key (id_funcionario)
);

create table obras(
    id_obra integer not null auto_increment,
    nomeO varchar(35) not null,
    descricao varchar(50) not null,
    endereco varchar(100) not null,
    primary key(id_obra)
);

create table poss(
    id_funcionario integer not null,
    id_obra integer not null,
    hora_inicio integer not null,
    hora_prevista integer not null,
    constraint fk_func foreign key (id_funcionario)
	references funcionarios(id_funcionario),
    constraint fk_poss foreign key (id_obra)
	references obras(id_obra),
    primary key (id_funcionario, id_obra)
);

create view vw_obras as
select f.id_funcionario, o.id_obra, f.nome, fun.funcao, o.nomeO, o.descricao, p.hora_inicio, p.hora_prevista
from funcoes fun
inner join funcionarios f on fun.id_funcao = f.id_funcionario
inner join poss p on f.id_funcionario = p.id_funcionario
inner join obras o on p.id_obra = o.id_obra
order by f.id_funcionario;

insert into funcoes(funcao) values
("Pedreiro"),
("Eletricista"),
("Encanador"),
("Carpinteiro");

insert into funcionarios(nome, valorHora) values
("Rafael Silva", 12.00),
("Fernanda Sousa", 12.75),
("Edinaldo Pereira", 10.50),
("Marta Gomes", 100.00),
("Matheus Alves", 100.00);


insert into obras(nomeO, descricao, endereco) values
("Pedreira", "Reformar um quarto", "Rua José Serra, Jardim Andrade, 456"),
("Amparo", "Trocar fiação", "Rua José Serra, Jardim Andrade, 200"),
("Jaguariúna", "Arrumar encanação", "Rua Antônio Fanti, Jardim Andrade, 173");

insert into poss(id_funcionario, id_obra, hora_inicio, hora_prevista) values
(1, 1, 12, 16),
(2, 2, 07, 17),
(3, 3, 08, 18);

Select * , hora_prevista - hora_inicio as totalHora, (hora_prevista - hora_inicio)*f.valorHora as totalDiara from poss p
inner join funcionarios f on p.id_funcionario = f.id_funcionario;

select * from funcoes;
select * from funcionarios;
select * from poss;
select * from obras;
select * from vw_obras;
show tables;

