package ceu.dam.javafx.practica1.app;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {

	public static final String FXML_LOGIN = "/app/login/login.fxml";
	public static final String FXML_COMBOBOX = "/app/login/comboBox.fxml";
	public static final String FXML_DATECHOOSER = "/app/login/dateChooser.fxml";
	public static final String FXML_COLORCHOOSER = "/app/login/colorChooser.fxml";
	public static final String FXML_MENU = "/app/login/menu.fxml";
	public static final String FXML_SLIDER = "/app/login/slider.fxml";

	public static Stage primaryStage;

	public AppController() {
	}

	public AppController(Stage stage) {
		primaryStage = stage;

	}

	public AppController changeScene(String fxml) {
		try {

			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addParam(String key, Object param) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();

		if (mapa == null) {
			mapa = new HashMap<String, Object>();
			primaryStage.setUserData(mapa);
		}
		mapa.put(key, param);
	}

	public Object getParam(String key) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		return mapa.get(key);

	}

}
