drop database if exists biblioteca;
create database biblioteca;
use biblioteca;

create table livro(
	cod int primary key auto_increment,
    nome varchar(255) not null,
    ano varchar(4),
    editora varchar(255),
    cidade varchar(255),
    status_livro varchar(255)
)engine=InnoDB;

create table usuario(
	cod int primary key auto_increment,
	nome varchar(255) not null,
	email varchar(255) not null,
	senha varchar(8) not null
)engine=InnoDB;

create table funcionario(
	cod int primary key auto_increment,
	nome varchar(255) not null,
	email varchar(255) not null,
	senha varchar(8) not null
)engine=InnoDB;

create table emprestimo(
	cod int primary key auto_increment,
	dataemprestimo date,
	datadevolucao date,
	fk_cod_usuario int,
	fk_cod_funcionario int,
	foreign key (fk_cod_funcionario) references funcionario(cod),
	foreign key (fk_cod_usuario) references usuario(cod)
)engine=InnoDB;

create table emprestimolivro(
	fk_cod_livro int,
	fk_cod_emprestimo int,
	foreign key (fk_cod_livro) references livro(cod),
	foreign key (fk_cod_emprestimo) references emprestimo(cod)
)engine=InnoDB;

insert into livro
	values(1,"cinderela","1993","irmãos griim","luxenburgo","Disponivel");
insert into livro
	values(2,"Runpeustinc","1945","irmãos griim","floriana","Disponivel");
insert into livro
	values(3,"João e jorel","1965","junter star","los angeles","Indisponivel");
insert into livro
	values(4,"after i suck my dick","2013","ana todinho","nova york","Indisponivel");
insert into livro
	values(5,"a cinco vacas de você","2053","Vacno Lares","lunore","Disponivel");
insert into livro
	values(6,"cirurgia fatal","1433","cirurgiao squad","los santos","Indisponivel");
insert into livro
	values(7,"abobrinha sem cabeça","2056","jonas abrotrinha","straberry","Disponivel");
insert into livro
	values(8,"como sobreviver em lugar nenhum","2034","lugar nenhum.inc","tiete","Indisponivel");
insert into livro
	values(9,"Informática Para Cachorros","2077","lershot","night city","Disponivel");
insert into livro
	values(10,"Lógica de Programação para Rothveillers","2065","reddow","valentine","Indisponivel");

insert into usuario
	values(1,"josoares","ronaldinho@gmail.com","joninho");
insert into usuario
	values(2,"Filomena","cacetenho@luarte.com","cuca553");
insert into usuario
	values(3,"Genivaldo","pocarrontas@jonas.com","renan");
insert into usuario
	values(4,"arthur","arthurzinho@facebook.com","faceap");
insert into usuario
	values(5,"ronaldinho","ronanto@gmail.com","rolinha");
    
insert into funcionario
	values(null, "Ricardo","ricardoblindao@gmail.com","2000");
insert into funcionario
	values(null, "jose","jose@gmail.com","2001");


insert into emprestimo (fk_cod_usuario,fk_cod_funcionario,cod,dataemprestimo,datadevolucao) values (2,1,0,"2019/03/21","2019/03/31");
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (1,1);
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (3,1);

insert into emprestimo (fk_cod_usuario,fk_cod_funcionario,cod,dataemprestimo,datadevolucao) values (3,2,0,"2019/03/21","2019/03/31");
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (4,2);
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (2,2);

insert into emprestimo (fk_cod_usuario,fk_cod_funcionario,cod,dataemprestimo,datadevolucao) values (1,1,0,"2019/03/21","2019/03/31");
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (9,3);
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (8,3);

insert into emprestimo (fk_cod_usuario,fk_cod_funcionario,cod,dataemprestimo,datadevolucao) values (5,1,0,"2019/03/21","2019/03/31");
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (6,4);

insert into emprestimo (fk_cod_usuario,fk_cod_funcionario,cod,dataemprestimo,datadevolucao) values (4,2,0,"2019/03/21","2019/03/31");
insert into emprestimolivro (fk_cod_livro,fk_cod_emprestimo) values (5,5);

select * from livro where status_livro = "D";
select * from livro where status_livro = "I";
select * from emprestimo where fk_cod_usuario = 2;
select * from livro where ano < 2017;
select * from livro where cidade = "los angeles";
update usuario set nome = "Genivaldo" where cod = 3;
update usuario set nome = "Filomena" where cod = 2;
update livro set nome = "Informática Para Cachorros" where cod = 9;
update livro set nome = "Lógica de Programação para Rothveillers" where cod = 10;
delete from livro where cod = 5;
delete from livro where cod = 2;
delete from livro where nome like '%a%';