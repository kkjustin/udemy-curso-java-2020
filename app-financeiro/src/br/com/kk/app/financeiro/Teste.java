package br.com.kk.app.financeiro;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.kk.app.Calculadora;

public class Teste {
	
	public static void main(String[] args) {
		
		Calculadora calc = ServiceLoader
				.load(Calculadora.class)
				.findFirst()
				.get();
		
		System.out.println(calc.soma(2, 3, 4));
		
		// Esta acessando o módulo de Logger via módulo da calculadora (transitive)
		// System.out.println(calc.getLoggerClass());
		
		// OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
		// System.out.println(opAritmeticas.soma(4, 5, 6));
		
		try {
			Field fieldId = calc.getClass().getDeclaredFields()[0];
			fieldId.setAccessible(true);
			fieldId.set(calc, "DEF");
			fieldId.setAccessible(false);
			
			System.out.println(calc.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
