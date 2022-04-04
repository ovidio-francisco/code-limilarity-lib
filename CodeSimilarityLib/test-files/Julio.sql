drop database if exists biblioteca;
create database biblioteca;
 use biblioteca;
 
  create table Livro(
	cod int primary key auto_increment,
    Nome varchar (255) not null,
    Ano varchar (4),
    Editora varchar (255),
    Cidade varchar (255),
    Status varchar (1)
    );
    
     create table Usuario(
     Matricula int primary key auto_increment,
     Nome varchar (255) not null,
     email varchar (255) not null,
     Senha varchar (8) not null
     );
     
     create table Funcionario(
     cod int primary key auto_increment,
	nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(8) not null
     );
     
      create table Emprestimo(
      cod int primary key auto_increment,
      dataemprestimo date,
      datadevolucao date,
      fk_cod_usuario varchar(23),
      fk_cod_funcionario int,
      foreign key (fk_cod_funcionario) references funcionario(cod),
      foreign key (fk_cod_usuario) references usuario(cod)
      );
      
      create table EmprestimoLivro(
       fk_cod_livro int,
      fk_cod_emprestimo int,
      foreign key (fk_cod_livro) references livro(cod),
      foreign key (fk_cod_emprestimo) references emprestimo(cod)
      );
      
      -- 1)
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Livraria do céu","1990","LuLu","Ponte das Rosas Queimadas","D");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"O que são rosas pretas?","1997","Lyla","Cidade dos jardins pretos(sem racismo)","D");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Quem sou eu?","2004","Tinkie Winkie","Sol com rosto de bebê","E");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Onde estou?","2005","fing no flou","btrapzera","D");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Não to gostando da brincadeira, sério.","2006","Lyla","Cidade dos jardins pretos(sem racismo)","E");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"O adulto com autismo","1983","LuLu","Ponte das Rosas Queimadas","D");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"O palhaço que queria sorrir","1976","LuLu","Ponte das Rosas Queimadas","E");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Palhaço é você","1995","fing no flou","btrapzera","D");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Salvem os anjos","2006","Tinkie Winkie","Sol com rosto de bebê","E");
Insert into livro(cod,nome,ano,editora,cidade,status)
	values(0,"Conheça a felicidade","2009","Lyla","Cidade dos jardins pretos(sem racismo)","D");
    
    -- 2)
insert into Usuario(Matricula,nome,email,senha)
	values (0,"Richardo Lokão","Richardosão@hotmail.com","R123");
insert into Usuario(Matricula,nome,email,senha)
	values (0,"Sidinho Olivão","Sidinismo@hotmail.com","R13");
insert into Usuario(Matricula,nome,email,senha)
	values (0,"chardo Lão","chardosão@hotmail.com","R23");
insert into Usuario(Matricula,nome,email,senha)
	values (0,"Spooky scary skeleton","Halloween@hotmail.com","666");
insert into Usuario(Matricula,nome,email,senha)
	values (0,"ahscuy","sbusalbcs@hotmail.com","12453");

	-- 3)
insert into Funcionario(Nome,Cod,Email,Senha)
	values ("Spooky",0,"Spooky@hotmail.com","214");
insert into Funcionario(Nome,Cod,Email,Senha)
	values ("Skeleton",2,"Skeleton@hotmail.com","24");
    
	-- 4) a)
insert into Emprestimo(cod,dataemprestimo,datadevolucao,fk_cod_usuario,fk_cod_funcionario)
	values(0,2019-07-23,2019-07-31,2,1);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (1,1);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (3,1);

	-- 4) b)
insert into Emprestimo(cod,dataemprestimo,datadevolucao,fk_cod_usuario,fk_cod_funcionario)
	values(0,2019-07-23,2019-07-31,3,2);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (4,1);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (2,1);

	-- 4) c)
insert into Emprestimo(cod,dataemprestimo,datadevolucao,fk_cod_usuario,fk_cod_funcionario)
	values(0,2019-07-23,2019-07-31,1,1);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (9,1);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (8,1);
    
	-- 4) d)
insert into Emprestimo(cod,dataemprestimo,datadevolucao,fk_cod_usuario,fk_cod_funcionario)
	values(0,2019-07-23,2019-07-31,4,2);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (6,1);

	-- 4) e)
insert into Emprestimo(cod,dataemprestimo,datadevolucao,fk_cod_usuario,fk_cod_funcionario)
	values(0,2019-07-23,2019-07-31,4,2);
insert into EmprestimoLivro( fk_cod_livro,fk_cod_emprestimo)
	values (5,1);
    
	-- 5)
Select * from livro where status="D";
	-- 6)
Select * from livro where status="E";
	-- 7)
Select * from emprestimo where fk_cod_usuario=2;
	-- 8)
Select * from livro where ano > 2;
	-- 9)
Select * from livro where cidade="São Paulo";
	-- 10)
Update usuario set nome="Genivaldo" where matricula=3;
	-- 11)
Update usuario set nome="Filomena" where matricula=2;
	-- 12)
Update livro set nome="Informática para cachorros" where cod=9;
	-- 13)
Update livro set nome="Lógica de Programação para Rothveillers" where cod=10;
	-- 14)
delete from livro where cod=5;
	-- 15)
delete from livro where cod=2;
	-- 16)
delete from livro where nome like "%a%";