package ceu.dam.javafx.examen.gui.controller;

import ceu.dam.javafx.examen.model.Coche;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NuevaReparacionController extends AppController {

	private Coche coche;

	@FXML
	private Label labelCoche;

	@FXML
	private Label labelDatos;

	@FXML
	private Label labelNo;

	@FXML
	private Label labelNueva;

	@FXML
	private void initialize() {
		//coche = new Coche();
		coche = (Coche) getParam(PARAM_MATRICULA);

		labelDatos.setText(coche.toString());

	}

}
