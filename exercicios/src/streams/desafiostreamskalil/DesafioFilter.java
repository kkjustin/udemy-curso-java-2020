package streams.desafiostreamskalil;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {
	
	public static void main(String[] args) {
		
		//@SuppressWarnings("unused")
		Consumer<Object> println = System.out::println;
		
		var p1 = new Produto("Caneta", 2.55, 258);
		var p2 = new Produto("Notebook", 4500.55, 2);
		var p3 = new Produto("Mochila", 55.99, 100);
		var p4 = new Produto("Borracha", 0.50, 743);
		var p5 = new Produto("Estojo", 11.99 , 5);
		var p6 = new Produto("Lápiseira", 4.50, 50);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6);
		
		Predicate<Produto> vendidosMais50 = 
				prod -> prod.vendidos > 50;
				
		Function<Produto, Double> totalVendido = 
				prod -> prod.preco * prod.vendidos;
				
		Function<Double, String> converter = 
				num -> new DecimalFormat("R$ #,###,##0.00").format(num);
		
		produtos.stream()
			.filter(vendidosMais50)
			.map(totalVendido)
			.map(converter)
			.forEach(println);
	}
}
