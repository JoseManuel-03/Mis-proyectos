package ceu.dam.javafx.practica1.webView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewController {

	@FXML
	private Button botonConsultar;
	
    @FXML
    private TextField textField;
    
	@FXML
	private WebView webView;

	@FXML
	void cargarUrl(ActionEvent event) {
		WebEngine webEngine = webView.getEngine();
		String url = textField.getText();
		webEngine.load(url);

	}

}
