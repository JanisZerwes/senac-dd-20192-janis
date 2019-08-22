drop database if exists Janis; 

create database janis;

use janis;

create table endereco(
idendereco int not null auto_increment primary key
, rua varchar(80)
, cep varchar (80)
, estado varchar(80)
, cidade varchar(80)
, numero varchar(80)
, bairro varchar(80)
);


create table Cliente(
idcliente int not null auto_increment primary key
, nome varchar (80)
, cpf varchar(12)
, sobrenome varchar(80)
, idendereco int
, foreign key (idendereco) references endereco(idendereco)
);




create table Telefone (
    idtelefone int not null auto_increment primary key,
    codgoPais varchar(10),
    DDD varchar(4),
    numero varchar(14),
    tipo varchar(10),
    ativo boolean,
    idcliente int,
    foreign key (idcliente)
        references cliente (idcliente)
);

