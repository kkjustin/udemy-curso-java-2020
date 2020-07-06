package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePessoas {
	
	static Connection conexao = FabricaConexao.getCononexao();
	
	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		Integer opcao, id;
		String novoNome;
		Pessoa pessoa;

		do {
			
			System.out.println("1) Listar pessoas.\n"
					+ "2) Adiconar uma pessoa.\n"
					+ "3) Alterar uma pessoa.\n"
					+ "4) Excluir uma pessoa.\n"
					+ "0) Sair.\n");
			
			System.out.print("Digite uma opção: ");
			opcao = entrada.nextInt();
			System.out.println();
			
			switch (opcao) {
				case 1:
					List<Pessoa> pessoas = buscarPessoas();
					listarPessoas(pessoas);
					break;
				case 2:
					entrada.nextLine();
					System.out.print("Insira o nome da pessoa a ser cadastrada: ");
					novoNome = entrada.nextLine();
					cadastrarPessoa(novoNome);
					System.out.println(novoNome + " cadastrado com sucesso!");
					break;
				case 3:
					entrada.nextLine();
					System.out.print("Digite o ID a ser alterado: ");
					id = entrada.nextInt();
					pessoa = buscarPessoa(id);
					
					if(pessoa != null) {
						System.out.println();
						System.out.println("Alterar " + pessoa.getNome() + "?");
						System.out.print("Sim(1) / Não(2): ");
						int alterar = entrada.nextInt();
						
						if(alterar == 1) {
							entrada.nextLine();
							System.out.print("Digite o novo nome da pessoa: ");
							novoNome = entrada.nextLine(); 
							alterarPessoa(id, novoNome);
							System.out.println("Pessoa alterada com sucesso!");
						}
					}
					break;
				case 4:
					entrada.nextLine();
					System.out.print("Digite o ID a ser excluido: ");
					id = entrada.nextInt();
					
					pessoa = buscarPessoa(id);
					
					if(pessoa != null) {
						System.out.println("Deseja excluir '" + pessoa.getNome() + "' ?" );
						System.out.print("Sim(1) / Não(2): ");
						int excluir = entrada.nextInt();
						
						if(excluir == 1) {
							Integer linhasAfetadas = excluirPessoa(id);
							System.out.println(linhasAfetadas + " linha(s) excluída(s)!");
						}
					}
					break;
			}
			
			System.out.println();
			
		} while (opcao > 0);
		
		entrada.close();
		conexao.close();
	}

	private static Pessoa buscarPessoa(Integer id) throws SQLException{
		
		String sql  = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			return new Pessoa(resultado.getInt(1), resultado.getString(2));
		};
		return null;
	}

	private static Integer excluirPessoa(Integer id) throws SQLException {
		
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt.executeUpdate();		
	}

	private static void alterarPessoa(Integer id, String nome) throws SQLException{
		
		String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setInt(2, id);
		stmt.execute();
	}

	private static void cadastrarPessoa(String nome) throws SQLException {
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
	}

	private static void listarPessoas(List<Pessoa> pessoas) {
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " => " + p.getNome());
		}
	}

	private static List<Pessoa> buscarPessoas() throws SQLException{
		
		String sql  = "SELECT codigo, nome FROM pessoas";
		Statement stmt = conexao.createStatement();
		
		ResultSet resultado = stmt.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while (resultado.next()) {
			pessoas.add(new Pessoa(resultado.getInt(1), resultado.getString(2)));
		}
		
		return pessoas;
	}
}