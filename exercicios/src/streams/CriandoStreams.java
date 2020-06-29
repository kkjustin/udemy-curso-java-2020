package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) {
		
		// Cria uma função para que referencia print
		Consumer<String> print = System.out::print;
		// Consumer<Object> print = System.out::print; // Está é uma opção que imprime inteiros e númericos
		@SuppressWarnings("unused")
		Consumer<Integer> println = System.out::println;
		
		// Cria um stream diretamente
		Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n");
		langs.forEach(print);
		
		String[] maisLangs = {"Python ", "Lisp ", "Perl ", "Go\n"};
		
		// Cria stream a partir de um Array
		Stream.of(maisLangs).forEach(print);
		Arrays.stream(maisLangs).forEach(print);
		Arrays.stream(maisLangs, 1, 4).forEach(print); // Cria o Stream a partir de parte do array (índice, índice - 1)
		
		// Criando Streams a partir de collections
		List<String> outrasLangs = Arrays.asList("C ", "PHP ", "Kotlin\n");
		outrasLangs.stream().forEach(print);
		outrasLangs.parallelStream().forEach(print);
		
		// Stream.generate(() -> "a").forEach(print);; // Stream infinita que aparece a diversas vezes
		// Stream.iterate(0, n -> n + 1).forEach(println); // Stream infinita que permite uma função unária
	}
}
