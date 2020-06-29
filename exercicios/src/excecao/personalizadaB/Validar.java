package excecao.personalizadaB;

public class Validar {

	private Validar() {}
	
	public static void aluno(Aluno aluno)
				throws NumeroForaIntervaloException, StringVaziaException {
		
		if(aluno == null) {
			throw new IllegalArgumentException("O aluno esta nulo!");
		}
		
		if(aluno.nome == null || aluno.nome.trim().isEmpty()) {
			throw new StringVaziaException("nome");
		}
		
		if(aluno.nota < 0 || aluno.nota > 10) {
			throw new NumeroForaIntervaloException("nota");
		}
	}
}
