package app;



import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		AppController controller = new AppController(primaryStage);
		controller.changeScene(AppController.FXML_HOLA_MUNDO);
		primaryStage.setResizable(false);
		primaryStage.setTitle("MI PRIMERA APP TEST");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
