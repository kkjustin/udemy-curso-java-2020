package streams;

import java.util.function.UnaryOperator;

public class Utilitarios {
	
	private Utilitarios() {
		
	}
	
	// Lambda
	public final static UnaryOperator<String> maiuscula = 
			n -> n.toUpperCase();
	
	//Lambda
	public final static UnaryOperator<String> primeiraLetra = 
			n -> n.charAt(0) + "";
	
	// Função
	public final static String grito(String n) {
		return n + "!!! ";
	}
}
