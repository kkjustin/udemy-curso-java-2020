module app.calculo {
	
	// Transitive passa as informa��es de do m�dulo para terceiros
	requires transitive app.logging;
	exports br.com.kk.app.calculo;
	
	exports br.com.kk.app.calculo.interno
	to app.financeiro;
	
	// Pode usar OPEN no modulo todo que vai abrir tudo
	// Pode usar OPENS que abre somente um pacote especifico
	// Pode usar OPENS e adicionar TO que abre um pacote expecifico para um m�dulo especifico (pode adicionar mais m�dulos separando por virgula)
	opens br.com.kk.app.calculo to app.financeiro;
	
	// Utiliza o m�dulo da interface (Calculadora)
	requires app.api;
	// Prove uma implementa��o para a interface Calculadora que esta em CalculadoraImpl
	provides br.com.kk.app.Calculadora
		with br.com.kk.app.calculo.CalculadoraImpl;
}