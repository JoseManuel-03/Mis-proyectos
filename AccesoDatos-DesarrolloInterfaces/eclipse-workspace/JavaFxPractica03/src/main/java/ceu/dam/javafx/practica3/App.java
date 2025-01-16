package ceu.dam.javafx.practica3;

import ceu.dam.javafx.practica3.gui.AppController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AppController controller = new AppController(primaryStage);
		controller.changeScene(AppController.FXML_CONSULTA);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
