package ceu.dam.javafx.practica1.menu;

import ceu.dam.javafx.practica1.app.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MenuController extends AppController {

	@FXML
	private BorderPane panel;

	@FXML
	private MenuItem colorPicker;

	@FXML
	private MenuItem comboBox;

	@FXML
	private MenuItem datePicker;

	@FXML
	private MenuItem slider;

	@FXML
	private MenuItem HtmlEditor;

	@FXML
	private MenuItem webView;

	@FXML
	void abrirColorPicker(ActionEvent event) {
		panel.setCenter(loadScene(FXML_COLORCHOOSER));
	}

	@FXML
	void abrirComboBox(ActionEvent event) {
		panel.setCenter(loadScene(FXML_COMBOBOX));

	}

	@FXML
	void abrirDatePicker(ActionEvent event) {
		panel.setCenter(loadScene(FXML_DATECHOOSER));

	}

	@FXML
	public void abrirSlider(ActionEvent event) {
		panel.setCenter(loadScene(FXML_SLIDER));

	}

	@FXML
	void abrirHmlEditor(ActionEvent event) {
		panel.setCenter(loadScene(FXML_HTMLEDITOR));

	}

	@FXML
	void abrirWebView(ActionEvent event) {
		panel.setCenter(loadScene(FXML_WEBVIEW));
	}

	@FXML
	void salirSesion(ActionEvent event) {
		changeScene(FXML_LOGIN);
	}

	@FXML
	void salirApp(ActionEvent event) {
		System.exit(0);
	}

}
