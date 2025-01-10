package ceu.dam.javafx.practica1.slider;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SliderController {

	@FXML
	private Button boton;

	@FXML
	private Slider slider;

	@FXML
	private TextField textField;

	@FXML
	void mostrarTexto(ActionEvent event) {
		Double valor = slider.getValue();
		BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
		textField.setText(bd.toString()	);

	}

}
