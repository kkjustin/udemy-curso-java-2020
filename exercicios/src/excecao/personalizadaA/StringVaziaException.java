package excecao.personalizadaA;

@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException{
	
	private String nomeDoAtributo;
	
	StringVaziaException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	public String getMessage() {	
		return String.format("O atributo '%s' está vazio",
				nomeDoAtributo);
	}
}
