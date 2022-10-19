package com.mycompany.eyemarket;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

    public static void main(String[] args) {
        Conexao connect = new Conexao();
        JdbcTemplate banco = connect.getConnection();
        TelaLogin telaLogin = new TelaLogin();
        
        banco.execute("DROP table empresa if exists;");
        banco.execute("DROP table TipoPerfil if exists;");
        banco.execute("DROP table Usuario if exists;");
        banco.execute("DROP table Totem if exists;");
        banco.execute("DROP table Componente if exists;");
        banco.execute("DROP table DadosTotem if exists;");
        
        
        banco.execute(
                "create table Empresa("
                + "IDEmpresa INT PRIMARY KEY AUTO_INCREMENT,"
                + "Nome VARCHAR(100),"
                + "Rua VARCHAR(800),"
                + "Numero INT,"
                + "CEP INT,"
                + "CNPJ CHAR (14)"
                + ");"
        );

        banco.execute(
                "CREATE TABLE Usuario("
                + "IDUsuario INT PRIMARY KEY AUTO_INCREMENT,"
                + "NomeCompleto VARCHAR(100),"
                + "Email VARCHAR(100),"
                + "Senha VARCHAR (20),"
                + "Telefone INT,"
                + "Cargo VARCHAR (20),"
                + "FKEmpresa INT,"
                + "FOREIGN KEY (FKEmpresa) REFERENCES Empresa (IDEmpresa));"
        );

        banco.execute(
                "CREATE TABLE Totem ("
                + "IDTotem INT PRIMARY KEY AUTO_INCREMENT,"
                + "Modelo INT"
                + ");"
        );

        banco.execute(
                "CREATE TABLE Componente("
                + "IDComponente INT PRIMARY KEY AUTO_INCREMENT,"
                + "HD VARCHAR(200),"
                + "CPU_ VARCHAR (200),"
                + "RAM VARCHAR (200),"
                + "FKTotemid INT,"
                + "FOREIGN KEY (FKTotemid) REFERENCES Totem (IDTotem));"
        );

        banco.execute(
                "CREATE TABLE DadosTotem ("
                + "IDDadosTotem INT PRIMARY KEY AUTO_INCREMENT,"
                + "UsoMemoria CHAR(20),"
                + "Temperatura DECIMAL (5,1),"  
                + "QtdProcesso INT,"
                + "Atividade VARCHAR (500),"
                + ");"
        );
       
        
        banco.execute(
                "INSERT INTO Empresa VALUES(1,'Carrefour','Rua Ramos Ortencia',20,0845677,'56765789876576');"
        );
        
        banco.execute(
                "INSERT INTO Usuario VALUES(null,'Carlos Alberto','carlos@gmail.com',123456,966325595,'Gestor',1);"
        );
        
        telaLogin.setVisible(true);
    }
}
