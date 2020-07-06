package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {
		
		final String URL = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		final String USUARIO = "wm";
		final String SENHA = "wm2020";
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
		
		System.out.println("Banco criado com sucesso!");
		conexao.close();		
	}
}
