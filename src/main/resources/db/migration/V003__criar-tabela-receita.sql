create table receita(
	id bigint not null auto_increment,
    usuario_id bigint not null,
    ingrediente_id bigint not null,
    nome varchar(50) not null,
    tempo_de_preparo varchar(20) not null,
    modo_de_preparo varchar(10000) not null,
    dica varchar(1000),

    primary key (id)
);

alter table receita add constraint fk_receita_usuario
foreign key (usuario_id) references usuario(id);

alter table receita add constraint fk_receita_ingrediente
foreign key (ingrediente_id) references ingrediente(id);