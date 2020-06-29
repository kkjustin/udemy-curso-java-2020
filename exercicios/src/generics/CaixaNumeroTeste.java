package generics;

public class CaixaNumeroTeste {

	public static void main(String[] args) {
		CaixaNumero<Double> caixaA = new CaixaNumero<>(); // N�o aceita String, somente n�meros
		caixaA.guardar(1.2);
		System.out.println(caixaA.abrir());
		
		CaixaNumero<Integer> caixaB = new CaixaNumero<>(); // N�o aceita String, somente n�meros
		caixaB.guardar(12);
		System.out.println(caixaB.abrir());
	}
}
