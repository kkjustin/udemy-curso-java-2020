package streams.desafiostreams;

import java.text.DecimalFormat;

public class Produto {

	final String nome;
	final double preco;
	final double desconto;
	final double frete;
	
	public Produto(String nome, double preco, double desconto, double frete) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.frete = frete;
	}
	
	public String converterValor(Double valor) {
		
		return new DecimalFormat("R$ #,###,###,##0.00").format(valor);
	}
}