package ceu.dam.javafx;

import ceu.dam.javafx.gui.AppController;
import javafx.stage.Stage;
import javafx.application.Application;

public class App extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		AppController appController = new AppController(primaryStage);
		appController.changeScene(AppController.FXML_BIENVENIDA);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
	

}
