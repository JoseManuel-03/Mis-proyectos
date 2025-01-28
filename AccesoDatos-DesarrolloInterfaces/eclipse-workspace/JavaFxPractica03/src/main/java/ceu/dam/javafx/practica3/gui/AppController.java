package ceu.dam.javafx.practica3.gui;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import ceu.dam.javafx.practica3.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	
	public static final String FXML_ALTASEGUNDAA = "/app/altaSegunda.fxml";
	public static final String FXML_ALTA = "/app/alta.fxml";
	public static final String FXML_CONSULTA = "/app/consulta.fxml";

	private static Stage primaryStage;
	
	public AppController() {
	}
	
	public AppController(Stage stage){
		primaryStage = stage;
	}
	
	public AppController changeScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cambiando escena.", e);
		}
	}
	
	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cargando escena.", e);
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




