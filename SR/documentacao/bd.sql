drop database if exists SR;
create database SR;
use SR;

create table funcionarios(
    id_funcionario integer not null auto_increment, 
	nome varchar(35) not null,
    funcao varchar(15) not null,
    valorHora decimal(3,2) not null,
	primary key (id_funcionario)
);

create table poss(
    hora_inicio varchar(10) not null,
    hora_prevista varchar(10) not null,
    totalDiaria decimal(5,2) not null,
    constraint fk_func foreign key (id_funcionario)
	references funcionarios(id_funcionario),
    constraint fk_obra foreign key (id_obra)
	references obras(id_obra)
);

create table obras(
    id_obra integer not null auto_increment,
    nome varchar(35) not null,
    descricao varchar(50) not null,
    endereco varchar(100) not null,
    primary key (id_obra)
);

create view vw_obras as
select f.id_funcionario, f.nome, f.funcao, o.id_obra, o.nome, o.descricao, p.hora_inicio, p.hora_prevista
from funcionarios f 
inner join poss p on f.id_funcionario = p.id_funcionario
inner join obras o on o.id_obra = p.id_obra;

insert into funcionarios(nome, funcao, valorHora) values
("Edinaldo Pereira", "Encanador", 10.50),
("Rafael Silva", "Pedreiro", 12.00),
("Marta Gomes", "Engenheira", 100.00),
("Matheus Alves", "Arquiteto", 100.00),
("Fernanda Sousa", "Eletricista", 12,75);

insert into obras(nome, descricao, endereco) values
("Pedreira", "Reformar um quarto", "Rua José Serra, Jardim Andrade, 456"),
("Rafael Silva", "Trocar fiação", "Rua José Serra, Jardim Andrade, 200"),
("Marta Gomes", "Arrumar encanação", "Rua Antônio Fanti, Jardim Andrade, 173");

insert into poss(hora_inicio, hora_prevista, totalDiaria)
("12:00", "16:00", ),
("07:30", "17:30", ),
("08:00", "18:00", );
