package ceu.dam.javafx.practica1.comboBox;

import ceu.dam.javafx.practica1.app.AppController;

import ceu.dam.javafx.practica1.menu.MenuController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ComboBoxController extends AppController {
	
	
	private MenuController controller;

	@FXML 
	private Button botonImprimir;

	@FXML
	private Button botonLimpiar;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private Pane panel;

	@FXML
	private TextField textfield;

	@FXML
	private Button botonSlider;

	@FXML
	void abrirSlider(ActionEvent event) {
		controller.abrirSlider(event);
	}

	@FXML
	void mousePressedImprimir(ActionEvent event) {
		textfield.setText(comboBox.getValue().toString());
	}

	@FXML
	void mousePressedLimpiar(ActionEvent event) {
		textfield.clear();
		comboBox.getSelectionModel().clearSelection();

	}

	public void initialize() {
		comboBox.getItems().add("BLAS");
		comboBox.getItems().add("BLASITO");
		comboBox.getItems().add("BLASOTE");
	}

}
