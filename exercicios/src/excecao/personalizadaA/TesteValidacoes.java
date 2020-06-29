package excecao.personalizadaA;

public class TesteValidacoes {

	public static void main(String[] args) {
		
		// Teste tirar o Anna e negativar valor
		var aluno = new Aluno("Anna", 7);
		
		try {
			Validar.aluno(aluno);
			Validar.aluno(null);
		} catch (StringVaziaException e) {
			System.out.println(e.getMessage());
		} catch (NumeroForaIntervaloException |
				IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim!");
	}
}
