package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MenuController extends AppController {
	@FXML
	private MenuBar menuBar;

	@FXML
	private BorderPane panel;

	@FXML
	private MenuItem cerrarSesion;

	@FXML
	private MenuItem colorPicker;

	@FXML
	private MenuItem comboBox;

	@FXML
	private MenuItem datePicker;

	@FXML
	private MenuItem salir;

	@FXML
	private MenuItem slider;

	@FXML
	private MenuItem tabla;

	@FXML
	void presionarComboBox(ActionEvent event) {
		panel.setCenter(loadScene(FXML_COMBOBOX));
	}
	@FXML
	void presionarDatePicker(ActionEvent event) {
		panel.setCenter(loadScene(FXML_DATEPICKER));
	}
	@FXML
	void presionarSlider(ActionEvent event) {
		panel.setCenter(loadScene(FXML_SLIDER));
	}
	@FXML
	void presionarTabla(ActionEvent event) {
		panel.setCenter(loadScene(FXML_TABLA));
	}
	@FXML
	void presionarcolorPicker(ActionEvent event) {
		panel.setCenter(loadScene(FXML_COLORPICKER));
	}
	@FXML
	void presionarSalir(ActionEvent event) {
		mostrarSalir("¿QUIERES SALIR?");
	}
}
