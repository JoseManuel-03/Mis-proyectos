package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BienvenidaController extends AppController {

	@FXML
	private Button botonAcceder;

	@FXML
	private Button botonSalir;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextField textField;

	
	@FXML
	public void initialize() {
		comboBox.getItems().addAll("A", "B");
		textField.setDisable(true);
		botonAcceder.setDisable(false);
	}
	
	@FXML
	void presionarComboBox(ActionEvent event) {
		if (comboBox.getItems().equals("A")) {
			textField.setDisable(false);
			botonAcceder.setDisable(false);
		}

	}

	@FXML
	void presionarAcceder(ActionEvent event) {
		changeScene(FXML_ALTA);
	}

	@FXML
	void presionarSalir(ActionEvent event) {
		mostrarSalir("¿DESEA SALIR?");

	}

}
