package ceu.dam.javafx.practica1.app;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		AppController controller = new AppController(primaryStage);
		controller.changeScene(AppController.FXML_LOGIN);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
	