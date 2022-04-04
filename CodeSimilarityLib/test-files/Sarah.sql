drop database if exists Biblioteca;
create database Biblioteca;
use Biblioteca;

create table Livro(
	cod 		int primary key auto_increment,
	nome 		varchar(255) not null,
	ano 		varchar(4),
	editora 	varchar(255),
	cidade 		varchar(255),
	status 		varchar(1)
)engine = InnoDB;

create table Usuario(
	matricula 	int primary key auto_increment,
    nome 		varchar(255) not null,
    email 		varchar(255) not null,
    senha 		varchar(8) not null
)engine = InnoDB;

create table Funcionario(
	cod 		int primary key auto_increment,
	nome 		varchar(255) not null,
    email 		varchar(255) not null,
    senha 		varchar(8) not null 
)engine = InnoDB;

create table Emprestimo( 
	cod 				int primary key auto_increment, 
    data_emprestimo 	date,
    data_devolucao 		date,
    cod_Usuario			int,
    cod_Funcionario 	int ,
    foreign key (cod_Funcionario) references Funcionario(cod), 
    foreign key (cod_Usuario) references Usuario(matricula) 
)engine = InnoDB; 

create table Emprestimo_livro( 
	cod_Livro 			int ,
    cod_emprestimo 		int ,
    foreign key (cod_Livro) references Livro(cod), 
    foreign key (cod_Emprestimo) references Emprestimo(cod) 
)engine = InnoDB; 

-- Instruções:


-- l)cadastre 10 livros
	insert into Livro values(0,'Batata',2019,'Amém','São PAulo','d');
    insert into Livro values(0,'Amanhecer',2019,'Ontem','Cerquilho','e');
    insert into Livro values(0,'Sou Louca',2019,'Biruta','Tietê','d');
    insert into Livro values(0,'Não Mexa Comigo',2019,'AAA','Jumirim','e');
    insert into Livro values(0,'Amigos',2019,'Amém','Cerquilho','d');
    insert into Livro values(0,'2°Info',2019,'ETEC','São Paulo','e');
    insert into Livro values(0,'RAIVA',2019,'Ontem','Laranjal Paulista','d');
    insert into Livro values(0,'After',2019,'Biruta','Tatui','e');
    insert into Livro values(0,'1984',2019,'Hoje','Itu','d');
    insert into Livro values(0,'O príncipe Gato e a Ampulheta do Tempo',2019,'ETEC','Capivari','e');
    
-- 2)cadastre 5 usuairios 
	insert into Usuario values(0,'Gustavo Cabra Macho','macho@gmail.com',12345678);
    insert into Usuario values(0,'Mateus Web Namorada','namoradinho@gmail.com',87654321);
    insert into Usuario values(0,'Elyvelton Tonto','tontinho@gmail.com',12548);
    insert into Usuario values(0,'Sarah Pipoca Caramelo','pipoquinha@gmail.com',12151324);
    insert into Usuario values(0,'Desenvolvimento de Sistemas Info','2info@gmail.com',1254488);
    
-- 3)cadastre 2 funcionarios 
	insert into Funcionario values(0,'Mãe Socorro','socorrinho@gmail.com',456789);
    insert into Funcionario values(0,'Aceite a Jesus','dokimos@gmail.com',4851);

-- 4)cadastre um empresa (emprestimo)para: 
-- a) usuario com matricula 2, livros de codigo 1 e 3, funcionairio 1, datadevolucao e dataemprestimo
	insert into Emprestimo values(0,"2019-09-10","2019-09-20",2,1);
    insert into Emprestimo_livro values(1,1);
    insert into Emprestimo_livro values(3,1);

-- b) usuario com matricula 3, livros de codigo 4 e 2, funcionario 2, datadevolucao e dataemprestimo 
	insert into Emprestimo values(0,"2017-05-19","2019-12-28",3,2);
    insert into Emprestimo_livro values(4,2);
    insert into Emprestimo_livro values(2,2);
	
-- c) usuario com matricula 1, livros de codigo 9 e 8, funcionario 1, datadevolucao e dataemprestimo 
	insert into Emprestimo values(0,"2015-04-12","2004-05-19",1,1);
    insert into Emprestimo_livro values(9,3);
    insert into Emprestimo_livro values(8,3);

-- d) usuario com matricula 5, livros de codigo 6, funcionario 1, datadevolucao e dataemprestimo 
	insert into Emprestimo values(0,"2014-05-13","2005-12-25",5,1);
    insert into Emprestimo_livro values(6,4);

-- e) usuario com matricula 4, livros de codigo 5, funcionario 2, datadevolucao e dataemprestimo 
	insert into Emprestimo values(0,"2017-02-15","2019-10-10",4,2);
    insert into Emprestimo_livro values(5,5);

-- 5)liste todos os livros com status D (disponivel) 
	select * from Livro where status = "d";

-- 6)liste todos os livros com status E (emprestado) 
	select * from Livro where status = "e";

-- 7)liste somente os emprestimos feitos pelo usuario 2 
	select * from Emprestimo where cod_Usuario = "2";

-- 8)liste somente os livros com mais de 2 anos 
	select * from Livro where ano  > 2017;

-- 9)liste somente os livros com cidade da editora em São Paulo 
	select * from Livro where cidade = "São Paulo"

-- 10)atualize o name do usuario de matricula 3 para Genivaldo 
	update Usuario set nome = "Genivaldo" where matricula = 3;

-- 11)atualize o name do usuario de matricula 2 para Filomena 
	update Usuario set nome = "Filomena" where matricula = 2;

-- 12)atualize o name do livro de cod 9 para Informatica para cachorros 
	update Livro set nome = "Informatica para cachorros" where  cod = 9;

-- 13)atualize o name do livro de cod 10 para Logica de Programação para Rothveillers 
	update Livro set nome = "Logica de Programação para Rothveillers " where  cod = 10;

-- 14)delete o livro de cod 5 
	delete from Livro where cod = 3;

-- 15)delete o livro de cod 2 
	delete from Livro where cod = 2;

-- 16)delete todos os livros que tenham "a" no name
	delete from Livro where nome like"%a%";
	


