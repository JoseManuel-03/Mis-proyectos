package ceu.dam.javafx.practica1.dateChooser;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DateController {

	@FXML
	private Button botonLeer;

	@FXML
	private DatePicker datePicked;

	@FXML
	private TextField textField;

	@FXML
	void mousePressedLeer(ActionEvent event) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = datePicked.getValue().format(formatter);
		textField.setText(fechaFormateada.toString());
	}

}
