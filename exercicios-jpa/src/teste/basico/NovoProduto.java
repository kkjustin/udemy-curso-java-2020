package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
//		Produto produto = new Produto("Caneta", 7.45);
//		dao.abrirT().incluir(produto).fecharT().fechar();
		
//		Produto produto = new Produto("Notebook", 3569.32);
//		dao.incluirAtomico(produto).fechar();
		
		Produto produto = new Produto("Monitor 23", 779.98);
		dao.incluirAtomico(produto).fechar();
		
		System.out.println("ID do produto: " + produto.getId());
	}
}
