create table ingrediente(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    quantidade varchar(20) not null,
    tipoQuantidade varchar(20) not null,

    primary key (id)
);