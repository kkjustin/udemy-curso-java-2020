package streams.desafiostreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioStreams {

	public static void main(String[] args) {
		
		var p1 = new Produto("Caneta", 2.50, 0.35, 0);
		var p2 = new Produto("Lápis", 1.58, 0.02, 10);
		var p3 = new Produto("Caderno", 12.73, 0.2, 10);
		var p4 = new Produto("Notebook", 2468.99, 0.35, 0);
		var p5 = new Produto("Borracha", 0.72, 0.05, 1.50);
		var p6 = new Produto("Mochila", 67.99, 0.45, 20);
		
		/*
		 * Produtos com desconto maior que 30% 
		 * e frete grátis
		 * retorno: nome do produto, o preço e "super promoção"
		 */
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6);
		
		Predicate<Produto> filtraDesconto = 
				prd -> prd.desconto > 0.3;
				
		Predicate<Produto> filtraFreteGratis =
				prd -> prd.frete == 0;
				
		Function<Produto, String> converterTexto =
				prd -> "Super promoção: " + prd.nome + " por " 
							+ prd.converterValor(prd.preco * (1 - prd.desconto)) 
							+ " e frete grátis";
		
		produtos.stream()
			.filter(filtraDesconto)
			.filter(filtraFreteGratis)
			.map(converterTexto)
			.forEach(System.out::println);
	}
}
