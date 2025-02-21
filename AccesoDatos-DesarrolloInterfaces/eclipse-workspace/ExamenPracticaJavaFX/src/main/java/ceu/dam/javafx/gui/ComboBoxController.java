package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ComboBoxController extends AppController {

	private MenuController controller;

	@FXML
	private Button botonImprimir;

	@FXML
	private Button botonLimpiar;

	@FXML
	private Button botonSlider;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextField textfield;

	@FXML
	void presionarImprimir(ActionEvent event) {
		textfield.setText(comboBox.getValue().toString());
	}

	@FXML
	void presionarLimpiar(ActionEvent event) {
		textfield.clear();
		comboBox.getSelectionModel().clearSelection();
	}

	@FXML
	public void initialize() {
		comboBox.getItems().add("Blas");
		comboBox.getItems().add("Blau");
		comboBox.getItems().add("Laura");

	}


	@FXML
	void presionarSlider(ActionEvent event) {
		((BorderPane) getParam("BORDER_PANE")).setCenter(loadScene(FXML_SLIDER));
	}

}
