package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		Connection conexao = FabricaConexao.getCononexao();
		
		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa incluida com sucesso!");		
		entrada.close();
	}
}
