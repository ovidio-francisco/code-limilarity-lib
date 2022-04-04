drop database if exists biblioteca;
create database biblioteca;
use biblioteca;

create table livro(
	cod int primary key auto_increment,
    nome varchar(255) not null,
    ano varchar(4),
    editora varchar(255),
    cidade varchar(255),
    staatus varchar(1)
)engine = InnoDB;

create table usuario(
	matricula int primary key auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
	senha varchar(8) not null

)engine = InnoDB;

create table funcionario(
 cod int primary key auto_increment, 
 nome varchar(255) not null, 
 email varchar(255) not null, 
 senha varchar(8) not null 
) engine = InnoDB; 

create table emprestimo( 
cod int primary key auto_increment, 
dataemprestimo date, 
datadevolucao date,
cod_usuario varchar(1),
cod_funcionario int,
foreign key (cod_usuario) references funcionario(cod),
foreign key (cod_usuario) references usuario(matricula) 
); 

create table emprestimolivro(
cod_livro int,
cod_emprestimo int,
foreign key (cod_livro) references livro(cod), 
foreign key (cod_emprestimo) references emprestimo(cod) 
); 

-- l)cadastre 10 livros
insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'o pequeno principe', 2011, 'abril', 'São Paulo','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'carrosel-o livro', 2015, 'fofucha', 'Rio de janeiro','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'o pequeno principe', 2001, 'bibi-perigosa', 'Maranhão','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'o pequeno principe', 2015, 'fofucha', 'Rio de janeiro','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'o pequeno principe', 2003, 'abril', 'São Paulo','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'o pequeno principe', 2018, 'bibi-perigosa', 'Maranhão','d');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'q coisa', 2000, 'fofucha', 'Rio de janeiro','i');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'escolinha do professor raimundo', 2016, 'bibi-perigosa', 'Maranhão','d');

insert into livro(cod,nome,ano,editora,cidade,staatus) values(0,'linda e ignorante', 2011, 'abril', 'São Paulo','d');


-- 2)cadastre 5 usuAirios 

insert into usuario values(0, 'julia','julia@gmail.com','******');

insert into usuario values(0,'larilda','larilda@gmail.com','****');

insert into usuario values(0,'emilin','lin@gmail.com','**');

insert into usuario values(0,'vitor','vitin@gmail.com','****');

insert into usuario values(0,'thalyta','thaty@gmail.com','***');


-- 3)casdastre 2 funcionarios
 
insert into funcionario values(0,'melissa','lissinha@gmail.com','***');

insert into funcionario values(0,'florentina','florzinhapvp@gmail.com','***');




-- 4)cadastre um emprestimo para:
 
-- a) usuAirio cam matrAcula 2, livros de cA3digo 1 e 3, funcionAirio 1, datadevolucao e dataemprestimo 
-- b) usuAirio cam matrAcula 3, livros de cA3digo 4 e 2, funcionAirio 2, datadevolucao e dataemprestimo 
-- c) usuAirio com matrAcula 1, livros de cA3digo 9 e 8, funcionAirio 1, datadevolucao e dataemprestimo 
-- d) usuAirio cam matrAcula 5, livros de cA3digo 6, funcionAirio 1, datadevolucao e dataemprestimo 
-- e) usuAirio cam matrAcula 4, livros de cA3digo 5, funcionAirio 2, datadevolucao e dataemprestimo 


insert into emprestimo(cod, dataemprestimo, datadevolucao, cod_usuario, cod_funcionario) values (0, '2019-02-01', '2019-12-10', 2, 1 );
insert into emprestimo(cod, dataemprestimo, datadevolucao, cod_usuario, cod_funcionario) values (0, '2019-04-10', '2019-11-10', 3, 2 );
insert into emprestimo(cod, dataemprestimo, datadevolucao, cod_usuario, cod_funcionario) values (0, '2019-05-10', '2019-10-15', 1, 1 );
insert into emprestimo(cod, dataemprestimo, datadevolucao, cod_usuario, cod_funcionario) values (0, '2019-06-10', '2019-02-10', 5, 1 );
insert into emprestimo(cod, dataemprestimo, datadevolucao, cod_usuario, cod_funcionario) values (0, '2019-07-10', '2019-12-10', 4, 2);
insert into emprestimolivro(cod_livro, cod_emprestimo) values (1, 1 );
insert into emprestimolivro(cod_livro, cod_emprestimo) values (2, 1 );
insert into emprestimolivro(cod_livro, cod_emprestimo) values (3, 2 );
insert into emprestimolivro(cod_livro, cod_emprestimo) values (4, 2 );
insert into emprestimolivro(cod_livro, cod_emprestimo) values (5, 3);
insert into emprestimolivro(cod_livro, cod_emprestimo) values (6, 3);
insert into emprestimolivro(cod_livro, cod_emprestimo) values (7, 4 );
insert into emprestimolivro(cod_livro, cod_emprestimo) values (8, 5 );


-- 5)liste todos os livros com status D (disponAvel) 

Select * from livro where staatus = 'd';

-- 6)liste todos os livros com status E (emprestado) 

Select * from livro where staatus = 'i';

-- 7)liste somente os emprestimos feitos pelo usuario 2

Select * from emprestimo where cod_usuario = 2;

-- 8)liste somente os livros com mais de 2 anos 

Select * from livro where ano > 2;

-- 9)liste somente os livros com cidade da editora em São Paulo 

Select * from livro where editora = 'SP';

-- 10)atualize o name do usuario de matricula 3 para Genivaldo 

UPDATE usuario SET nome = 'Genivaldo '  WHERE matricula = '3';

-- 11)atualize o nome do usuario de matrAcula 2 para Filomena 

UPDATE usuario SET nome = 'Filomena '  WHERE matricula = '2';


-- 12)atualize o name do livro de cod 9 para InformAitica para cachorros

UPDATE livro SET nome = 'InformAitica para cachorros'  WHERE cod = '9';


-- 13)atualize o name do livro de cod 10 para LA3gica de ProgramaA§AEo para Rothveillers 

UPDATE livro SET nome = 'LA3gica de ProgramaA§AEo para Rothveillers'  WHERE cod = '10';


-- 14)delete o livro de cod 5 

-- delete from livro where cod = 5


-- 15)delete o livro de cod 2 

-- delete from livro where cod = 2


-- 16)delete todos os livros que tenham a no nome 

-- delete from livro where nome like'%a%';




