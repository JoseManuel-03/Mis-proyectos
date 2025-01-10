package ceu.dam.javafx.practica1.colorChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class ColorChooserController {

	@FXML
	private Button boton;

	@FXML
	private ColorPicker color;

	@FXML
	private Label nombreColor;

	@FXML
	void cambiarLabel(ActionEvent event) {
		nombreColor.setTextFill(color.getValue());
	}

}
