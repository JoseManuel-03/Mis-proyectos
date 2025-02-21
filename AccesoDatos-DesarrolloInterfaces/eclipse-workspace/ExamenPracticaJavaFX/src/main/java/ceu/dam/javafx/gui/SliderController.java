package ceu.dam.javafx.gui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SliderController extends AppController {

	private MenuController controller;

	@FXML
	private Button botonLeer;

	@FXML
	private Slider slider;

	@FXML
	private TextField textfeld;

	@FXML
	void presionarLeer(ActionEvent event) {
		Double valor = slider.getValue();
		BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
		textfeld.setText(bd.toString());
	}
}
