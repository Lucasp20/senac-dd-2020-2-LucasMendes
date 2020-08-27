SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS COVID19;

CREATE DATABASE COVID19;
USE COVID19;

CREATE TABLE PESSOA (
	IDPESSOA INT NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    SEXO CHAR (1),
    CPF VARCHAR(11),
    REACAO INT, 
    DATA_VACINACAO DATE,
    VOLUNTARIO BOOLEAN,
    PRIMARY KEY (IDPESSOA)
);

CREATE TABLE VACINA (	
	IDVACINA INT NOT NULL AUTO_INCREMENT,
	PAIS_DE_ORIGEM VARCHAR (100),
    ESTAGIO_PESQUISA INT,
	DATA_INICIO_PESQUISA DATE,
	IDPESQUISADOR INT,
	FOREIGN KEY (IDPESQUISADOR) REFERENCES PESSOA (IDPESSOA),
	PRIMARY KEY (IDVACINA)
);

CREATE TABLE INSTITUICAO (
	IDINSTITUICAO INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100),
    RUA VARCHAR(100),
    BAIRRO VARCHAR(100),
    CIDADE VARCHAR(100),
    ESTADO CHAR(2),
	CNPJ VARCHAR(20),
    PRIMARY KEY (IDINSTITUICAO)
);


SELECT * FROM PESSOA; 
SELECT * FROM VACINA;
SELECT * FROM INSTITUICAO;