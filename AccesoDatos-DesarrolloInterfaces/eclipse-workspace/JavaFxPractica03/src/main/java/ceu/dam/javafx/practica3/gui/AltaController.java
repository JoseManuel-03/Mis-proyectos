package ceu.dam.javafx.practica3.gui;

import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalDataNotValidException;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		Animal animal = (Animal) getParam(PARAM_ANIMAL);
		animal.setTipo(textField.getText());

		try {
			animal.validarTipo();
			changeScene(FXML_ALTASEGUNDAA);

		} catch (AnimalDataNotValidException e) {
			mostrarPop(e.getMessage());
		}
	}

	public void initialize() {
		animal = new Animal();
		addParam(PARAM_ANIMAL, animal);
	}

}
