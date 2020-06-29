package generics;

public class CaixaNumeroTeste {

	public static void main(String[] args) {
		CaixaNumero<Double> caixaA = new CaixaNumero<>(); // Não aceita String, somente números
		caixaA.guardar(1.2);
		System.out.println(caixaA.abrir());
		
		CaixaNumero<Integer> caixaB = new CaixaNumero<>(); // Não aceita String, somente números
		caixaB.guardar(12);
		System.out.println(caixaB.abrir());
	}
}
