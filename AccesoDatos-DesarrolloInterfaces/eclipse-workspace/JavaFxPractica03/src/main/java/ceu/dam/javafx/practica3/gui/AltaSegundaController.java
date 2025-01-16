package ceu.dam.javafx.practica3.gui;

import java.io.Serial;

import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AltaSegundaController extends AppController {

	private AnimalesServices services;
	private Animal animal;
	@FXML
	private Button botonGuardar;

	@FXML
	private Label labelEdad;

	@FXML
	private Label labelNombre;

	@FXML
	private TextField textFieldEdad;

	@FXML
	private TextField textFiledNombre;

	@FXML
	void presionarBoton(ActionEvent event) {
		if (textFieldEdad.getText().isEmpty() || textFiledNombre.getText().isEmpty()) {
			mostrarPop();
			return;
		}
		animal.setEdad(Integer.parseInt(textFieldEdad.getText()));
		animal.setNombre(textFiledNombre.getText());
		changeScene(FXML_CONSULTA);
	}

	public void mostrarPop() {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(null);
		a.setContentText("El nombre y edad no pueden estar vacíos");
		a.setTitle("Error");
		a.showAndWait();

	}

}
