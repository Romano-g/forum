create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(500) not null,
    data datetime not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);