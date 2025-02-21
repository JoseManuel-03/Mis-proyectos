package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class ColorPickerController extends AppController {

	private MenuController controller;

	@FXML
	private Button boton;

	@FXML
	private ColorPicker colorPicker;

	@FXML
	private Label label;

	@FXML
	void presionarBoton(ActionEvent event) {
		label.setTextFill(colorPicker.getValue());
	}

}
