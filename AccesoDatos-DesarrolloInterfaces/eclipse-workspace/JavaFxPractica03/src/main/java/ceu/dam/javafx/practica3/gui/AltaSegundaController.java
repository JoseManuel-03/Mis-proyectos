package ceu.dam.javafx.practica3.gui;

import java.io.Serial;

import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalDataNotValidException;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AltaSegundaController extends AppController {

	private AnimalesServices services;
	private Animal animal;
	@FXML
	private Button botonGuardar;

	@FXML
	private Label labelEdad;

	@FXML
	private Label labelNombre;

	@FXML
	private TextField textFieldEdad;

	@FXML
	private TextField textFiledNombre;

	@FXML
	void presionarBoton(ActionEvent event) {
		try {
			animal.setEdad(Integer.parseInt(textFieldEdad.getText()));
			animal.setNombre(textFiledNombre.getText());
			animal.validarTodo();
			AnimalesServices service = new AnimalesServices();
			service.addAnimal(animal);
			ConsultaController controller = (ConsultaController) changeScene(FXML_CONSULTA);
			controller.consultar(animal.getTipo());

		} catch (NumberFormatException e) {
			mostrarPop("La edad no puede ser vacía y tiene que ser un número");
		} catch (AnimalDataNotValidException e) {
			mostrarPop(e.getMessage());
		}
	}

	public void initialize() {
		animal = (Animal) getParam(PARAM_ANIMAL);
	}

}
