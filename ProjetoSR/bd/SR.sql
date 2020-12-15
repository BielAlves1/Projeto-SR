drop database if exists SR;
create database SR;
use SR;

create table funcionario(
    id_funcionario integer not null auto_increment, 
    id_os integer not null,
	nome varchar(35) not null,
    funcao varchar(15) not null,
    valorHora decimal(6,2) not null,
    primary key (id_funcionario)
);

create table ordem_de_servico(
    id_os integer not null auto_increment,
    descricao varchar(50) not null,
    observacao varchar(30) not null,
    endereco varchar(100) not null,
    data_inicio date not null,
    data_entrega date not null,
    valor_os decimal(6,2) not null,
    primary key(id_os)
);

select * from funcionarios;
select * from ordem_de_servico;
show tables;

