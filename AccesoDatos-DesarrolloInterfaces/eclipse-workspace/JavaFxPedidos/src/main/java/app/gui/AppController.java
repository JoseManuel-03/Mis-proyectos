package app.gui;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {

	private static final String PATH_BASE = "/app/";

	public static final String FXML_ALTACLIENTE = PATH_BASE + "altaCliente.fxml";
	public static final String FXML_ALTAPEDIDO = PATH_BASE + "altaPedido.fxml";
	public static final String FXML_BUSCARPEDIDOS = PATH_BASE + "buscarPedidos.fxml";
	public static final String FXML_EDICION = PATH_BASE + "edicion.fxml";

	private static Stage primaryStage;

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
			throw new RuntimeException("Error cambiando escena.", e);

		}
	}

	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		} catch (IOException e) {
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

	public void mostrarPop(String mensaje) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(null);
		a.setContentText(mensaje);
		a.setTitle("Error");
		a.showAndWait();

	}

}
