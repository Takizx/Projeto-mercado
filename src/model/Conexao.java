package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/mercado";
    private static final String USER = "root"; 
    private static final String PASS = "admin"; 

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar à base de dados. Verifique se o MySQL está ativo e se a base de dados 'mercado' foi criada.", e);
        }
    }
}