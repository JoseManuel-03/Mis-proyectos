package ceu.dam.javafx.gui;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DatePickerController extends AppController {

	private MenuController controller;

	@FXML
	private Button botonLeer;

	@FXML
	private DatePicker datePicker;

	@FXML
	private TextField texfield;

	@FXML
	void presionarLeer(ActionEvent event) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = datePicker.getValue().format(formatter);
		texfield.setText(fechaFormateada.toString());
	}
}
