module app.financeiro {
	
	// Importado por padrao java.base
	requires java.base;
	// requires app.calculo;
	
	// Utiliza o módulo API (interface Calculadora)
	requires app.api;
	// Usa o método da interface (não se preocupa com "onde esta a implementação")
	uses br.com.kk.app.Calculadora;
}