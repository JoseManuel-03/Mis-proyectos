package ceu.dam.javafx.examen.gui.controller;

import ceu.dam.javafx.examen.model.Coche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class InicioController extends AppController {

	private Coche coche;

	@FXML
	private MenuItem buscar;

	@FXML
	private MenuItem cerrarApp;

	@FXML
	private MenuItem cerrarCoche;

	@FXML
	private Label labelCoche;

	@FXML
	private Label labelDatos;

	@FXML
	private MenuItem nueva;

	@FXML
	private Menu reparaciones;

	@FXML
	private Menu salir;

	@FXML
	private BorderPane panel;

	@FXML
	private void initialize() {
		//coche = new Coche();
		coche = (Coche) getParam(PARAM_MATRICULA);
		labelDatos.setText(coche.toString());

	}

	@FXML
	void presionarBuscar(ActionEvent event) {
		panel.setCenter(loadScene(FXML_BUSCARREPARACION));
	}

	@FXML
	void presionarCerrar(ActionEvent event) {
		panel.setCenter(loadScene(FXML_IDENTIFICACION));

	}

	@FXML
	void presionarCerrarApp(ActionEvent event) {
		mostrarSalir("¿Quieres salir?");

	}

	@FXML
	void presionarNueva(ActionEvent event) {
		panel.setCenter(loadScene(FXML_NUEVAREPARACION));

	}

}
