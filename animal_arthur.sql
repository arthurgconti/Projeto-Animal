CREATE DATABASE animal_arthur;
USE animal_arthur;

CREATE TABLE tbdono_arthur
(
	iddono int(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(40),
	cpf VARCHAR(11),
	datanascimento VARCHAR(10),
	senha VARCHAR(30),
	CONSTRAINT pkId PRIMARY KEY (iddono)
);

insert into tbdono_arthur (cpf,senha) values ('00000000000','123');


CREATE TABLE tbraca_arthur(
	idraca INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(30),
	CONSTRAINT pkIdraca_arthur PRIMARY KEY (idraca)
);


CREATE TABLE tbanimal_arthur(
	idanimal INT NOT NULL AUTO_INCREMENT,
	codraca INT,
	coddono INT,
	nome VARCHAR (30),
	tamanho VARCHAR(20),
	fase VARCHAR(20),
	dataadocao VARCHAR(10),
	
	CONSTRAINT pkIdanimal_arthur PRIMARY KEY (idanimal),
	CONSTRAINT fkCodraca_arthur FOREIGN KEY (codraca) REFERENCES tbraca_arthur(idraca),
	CONSTRAINT fkCoddono_arthur FOREIGN KEY (coddono) REFERENCES tbdono_arthur(iddono)
	
);