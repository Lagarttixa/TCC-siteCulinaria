create table usuario (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    senha varchar(20) not null,
    telefone varchar(12) not null,

    primary key (id)
);