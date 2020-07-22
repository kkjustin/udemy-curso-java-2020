package br.com.kk.app.calculo;

import br.com.kk.app.Calculadora;
import br.com.kk.app.calculo.interno.OperacoesAritmeticas;
import br.com.kk.app.logging.Logger;

public class CalculadoraImpl implements Calculadora {
	
	private String id = "ABC";

	private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
	
	public double soma(double... nums) {
		Logger.info("Somando...");
		return opAritmeticas.soma(nums);
	}
	
	// Recebe de outra classe (logger não pertence ao módulo de calculadora)
	public Class<Logger> getLoggerClass() {
		return Logger.class;
	}

	public String getId() {
		return id;
	}
}