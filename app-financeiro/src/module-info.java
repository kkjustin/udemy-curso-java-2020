module app.financeiro {
	
	// Importado por padrao java.base
	requires java.base;
	// requires app.calculo;
	
	// Utiliza o m�dulo API (interface Calculadora)
	requires app.api;
	// Usa o m�todo da interface (n�o se preocupa com "onde esta a implementa��o")
	uses br.com.kk.app.Calculadora;
}