module app.calculo {
	
	// Transitive passa as informações de do módulo para terceiros
	requires transitive app.logging;
	exports br.com.kk.app.calculo;
	
	exports br.com.kk.app.calculo.interno
	to app.financeiro;
	
	// Pode usar OPEN no modulo todo que vai abrir tudo
	// Pode usar OPENS que abre somente um pacote especifico
	// Pode usar OPENS e adicionar TO que abre um pacote expecifico para um módulo especifico (pode adicionar mais módulos separando por virgula)
	opens br.com.kk.app.calculo to app.financeiro;
	
	// Utiliza o módulo da interface (Calculadora)
	requires app.api;
	// Prove uma implementação para a interface Calculadora que esta em CalculadoraImpl
	provides br.com.kk.app.Calculadora
		with br.com.kk.app.calculo.CalculadoraImpl;
}