package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {

	public static void main(String[] args) {
		
		var a1 = new Aluno("Ana", 7.8);
		var a2 = new Aluno("Bia", 3.8);
		var a3 = new Aluno("Lia", 9.8);
		var a4 = new Aluno("Rebeca", 5.1);
		var a5 = new Aluno("Pedro", 7.1);
		var a6 = new Aluno("Luis", 10);
		
		Predicate<Aluno> estaAprovado = 
				aluno -> aluno.nota > 7;
				
		Function<Aluno, String> saudacaoAprovado = 
				a -> "Parabéns " + a.nome + "! Você foi aprovado!";
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);
		alunos.stream()
			.filter(estaAprovado)
			.map(saudacaoAprovado)
			.forEach(System.out::println);
	}
}
