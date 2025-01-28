package ceu.dam.javafx.practica3.gui;

import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class AltaController extends AppController {

	private AnimalesServices services;
	private Animal animal;
	@FXML
	private Button botonContinuar;

	@FXML
	private AnchorPane panelAltaTipo;

	@FXML
	private TextField textField;

	@FXML
	private Label tipoLabel;

	@FXML
	void presionarButon(ActionEvent event) {
		if (textField.getText().isEmpty()) {
			mostrarPop();
			return;
		}
	//	services.addAnimal(animal.setTipo(textField.getText()));
	//	changeScene(FXML_ALTASEGUNDAA);

	}

	public void mostrarPop() {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(null);
		a.setContentText("El tipo indicado no puede ser vacío");
		a.setTitle("Error");
		a.showAndWait();

	}

}
