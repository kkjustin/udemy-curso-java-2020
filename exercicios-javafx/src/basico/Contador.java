package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {
	
	private int contador;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		
		botaoDecremento.setOnAction(e -> {
			contador --;
			atualizarLabelNumero(labelNumero, contador);
			labelNumero.setText(Integer.toString(contador));
		});
		
		botaoIncremento.setOnAction(e -> {
			contador ++;
			atualizarLabelNumero(labelNumero, contador);
			labelNumero.setText(Integer.toString(contador));
		});
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.setSpacing(10);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		
		String caminhoCSS = getClass()
				.getResource("/basico/Contador.css")
				.toExternalForm();
		
		Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
		cenaPrincipal.getStylesheets().add(caminhoCSS);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		
		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}
	
	private void atualizarLabelNumero(Label label, int numero) {
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		if (numero < 0) {
			label.getStyleClass().add("vermelho");
		} else if (numero > 0) {
			label.getStyleClass().add("verde");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
