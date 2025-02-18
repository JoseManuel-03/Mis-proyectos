package ceu.dam.javafx.practica3.gui;

import ceu.dam.javafx.gui.AppController;
import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalDataNotValidException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Registro1Controller extends AppController{
	
	private Animal animal;

	@FXML
	private Button botonContinuar;

	@FXML
	private Label label;

	@FXML
	private TextField textField;

	@FXML
	void presionarContinuar(ActionEvent event) { 	
		Animal animal = (Animal)getParam(PARAM_ANIMAL);
		animal.setTipo(textField.getText());
		try {
			animal.validarTipo();
			changeScene(FXML_REGISTROSEGUNDO);
		} catch (AnimalDataNotValidException e) {
			mostrarPop(e.getMessage());
		}
		
	}
	
	@FXML
	public void initialize() {
		animal = new Animal();
		addParam(PARAM_ANIMAL, animal);
	}

}
