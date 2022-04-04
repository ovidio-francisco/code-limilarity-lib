drop database if exists biblioteca;
create database biblioteca;
use biblioteca;

create table Livro(
	cod int primary key auto_increment,
    nome varchar(255) not null,
    ano varchar(4),
    editora varchar(255),
    cidade varchar(255),
    status_livro varchar(1)
)engine = InnoDB;

create table Usuário(
	matricula int primary key auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(8) not null
)engine = InnoDB;

create table Funcionário(
	cod int primary key auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(8) not null
)engine = InnoDB;

create table Empréstimo(
	cod int primary key auto_increment,
    dataEmpréstimo date,
    dataDevolução date,
    fk_cod_Usuário int,
    fk_cod_Funcionário int,
    
    foreign key (fk_cod_Usuário) references Usuário(matricula), 
    foreign key (fk_cod_Funcionário) references Funcionário(cod)
)engine = InnoDB;

create table Empréstimo_Livro(
	fk_cod_Livro int,
    fk_cod_Empréstimo int,
    
    foreign key (fk_cod_Livro) references Livro(cod),
    foreign key (fk_cod_Empréstimo) references Empréstimo(cod)
)engine = InnoDb;


-- * Inserts * --

-- Livros --

insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "As aventuras de Zack e Cody", "2008", "Valdisney", "Orlando", "E");

insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "As aventuras de Zack e Cody cap. 2", "2009", "Valdisney", "Orlando", "D");

insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Fullmetal Alchemist", "2003", "Makoto Shindori", "Tokyo", "E");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Miojo com suco Tang", "2017" ,"Cancêr", "Cemitério", "E");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "A anatomia do jogador de Free Fire", "2019" ,"Corno", "Cornífera", "D");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Miranha Adventure's", "2016", "Valdisney & Marvete & Soninho", "Holly Wood", "E");

insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Egnima", "2018", "Viih Tube", "Sorocaba", "D");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Kaike comilão", "2016", "Alek Intelcoure", "São Paulo", "E");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Splinning Splein", "2017", "Alek Intelcoure", "São Paulo", "E");
    
insert into Livro(cod,nome,ano,editora,cidade,status_Livro)
	values(null, "Eu ví o que eu vejo", "2019", "Intrínseca", "São Paulo", "E");

-- Usuários --

insert into Usuário(matricula,nome,email,senha)
	values(null,"Cleiton", "cleitinhogamer@hotmail.com", "40028922");
    
insert into Usuário(matricula,nome,email,senha)
	values(null,"Jorge", "jorginho@hotmail.com", "777bro");

insert into Usuário(matricula,nome,email,senha)
	values(null,"Braia", "braia_do_corsa@gmail.com", "corsa9");

insert into Usuário(matricula,nome,email,senha)
	values(null,"Jubiscleiton", "jubi@outlook.com", "jubinho9");

insert into Usuário(matricula,nome,email,senha)
	values(null,"Marquinhos", "Relampagu_marquinhos@hotmail.com", "katchau!");

-- Funcionários --

insert into Funcionário(cod, nome, email, senha)
	values(null, "Dona Cida", "Cidinha@hotmail.com", "1912");
    
insert into Funcionário(cod, nome, email, senha)
	values(null, "Shirley", "SaladeBatePapo@hotmail.com", "666");
    
-- Empréstimos --

-- a)
insert into Empréstimo(cod, dataEmpréstimo, dataDevolução, fk_cod_Usuário, fk_cod_Funcionário)
	values(null, '2019-08-11', '2019-09-11', 2, 1);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(1, 1);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(3, 1);
    
-- b)
insert into Empréstimo(cod, dataEmpréstimo, dataDevolução, fk_cod_Usuário, fk_cod_Funcionário)
	values(null, '2016-07-01', '2016-08-01', 3, 2);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(4, 2);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(2, 2);
    
-- c)
insert into Empréstimo(cod, dataEmpréstimo, dataDevolução, fk_cod_Usuário, fk_cod_Funcionário)
	values(null, '2018-02-19', '2018-03-19', 1, 1);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(9, 3);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(8, 3);
    
-- d)
insert into Empréstimo(cod, dataEmpréstimo, dataDevolução, fk_cod_Usuário, fk_cod_Funcionário)
	values(null, '2015-06-18', '2015-07-18', 5, 1);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(6, 4);
    
-- e)
insert into Empréstimo(cod, dataEmpréstimo, dataDevolução, fk_cod_Usuário, fk_cod_Funcionário)
	values(null, '2017-11-09', '2017-12-09', 4, 2);
    
insert Empréstimo_Livro(fk_cod_Livro, fk_cod_Empréstimo)
	values(5, 5);
    
    
-- * Selects * -- 

-- 5)
Select * from Livro where status_livro = "D";

-- 6)
Select * from Livro where status_livro = "E";

-- 7)
Select * from Empréstimo where fk_cod_Usuário = 2;

-- 8)
 select * from Livro where ano < 2017;

-- 9)
Select * from Livro where cidade = "São Paulo";

-- 10)
Update Usuário set nome = "Genivaldo" where matricula = 3;

-- 11)
Update Usuário set nome = "Filomena" where matricula = 2;

-- 12)
Update Livro set nome = "Informática para cachorros" where cod = 9;

-- 13)
Update Livro set nome = "Lógica de Programação para Rotheveillers" where cod = 10;

-- 14)
Delete from Livro where cod = 5;

-- 15)
Delete from Livro where cod = 2;

-- 16)
Delete from Livro where nome like ("%a%");
