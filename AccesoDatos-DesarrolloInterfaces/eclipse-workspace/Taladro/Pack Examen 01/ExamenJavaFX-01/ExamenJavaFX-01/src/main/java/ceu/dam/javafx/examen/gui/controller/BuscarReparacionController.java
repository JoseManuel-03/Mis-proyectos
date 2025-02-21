package ceu.dam.javafx.examen.gui.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ceu.dam.javafx.examen.model.Coche;
import ceu.dam.javafx.examen.model.Reparacion;
import ceu.dam.javafx.examen.service.ExamenService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BuscarReparacionController extends AppController {

	private ExamenService service;
	private Coche coche;

	@FXML
	private Button botonActualizar;

	@FXML
	private CheckBox checkBox;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Label labelCoche;

	@FXML
	private Label labelDatos;

	@FXML
	private TableView<Reparacion> tabla;

	@FXML
	private TableColumn<Reparacion, LocalDate> tipoFecha;

	@FXML
	private TableColumn<Reparacion, String> tipoOperario;

	@FXML
	private TableColumn<Reparacion, Double> tipoPresupuesto;

	@FXML
	void presionarActualizar(ActionEvent event) {
		List<Reparacion> lista = service.consultarReparaciones(datePicker.getValue(), coche.getMatricula());
		if (lista.isEmpty()) {

		}
	}

	@FXML
	void presionarTodas(ActionEvent event) {
		datePicker.setDisable(true);
		if (datePicker.isDisable() && datePicker.isPressed()) {
			datePicker.setDisable(false);
		}
	}

	@FXML
	private void initialize() {
		service = new ExamenService();
		coche = new Coche();
		labelDatos.setText(coche.toString());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		datePicker.setValue(LocalDate.now());
		datePicker.getValue().format(formatter);

		coche = (Coche) getParam(PARAM_MATRICULA);

	}
}
