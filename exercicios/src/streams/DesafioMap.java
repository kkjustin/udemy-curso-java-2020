package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		
		/*
		 * 1 - Número para String binária... 6 => "110"
		 * 2 - Reverter a String... "110" => "011"
		 * 3 - Converter para inteiro... "011" => 3
		 */
		
		Consumer<Integer> println = System.out::println;
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		//Function<Integer, String> paraBinario = n -> Integer.toBinaryString(n);
		UnaryOperator<String> reverter = 
				s -> new StringBuilder(s).reverse().toString();
				
		Function<String, Integer> paraInteiro = 
				s -> Integer.parseInt(s, 2);
		
		nums.stream()
		//.map(paraBinario)
		.map(Integer::toBinaryString)
		.map(reverter)
		.map(paraInteiro)
		.forEach(println);
		
	}
}
