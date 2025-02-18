package ceu.dam.javafx.practica3;


import ceu.dam.javafx.practica3.gui.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		AppController appController = new AppController(primaryStage);
		appController.changeScene(AppController.FXML_TABLA);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}
