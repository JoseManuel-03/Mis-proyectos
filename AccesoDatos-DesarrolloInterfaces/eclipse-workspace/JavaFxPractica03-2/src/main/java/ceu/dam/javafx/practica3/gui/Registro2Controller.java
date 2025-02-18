package ceu.dam.javafx.practica3.gui;

import ceu.dam.javafx.gui.AppController;
import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalDataNotValidException;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Registro2Controller extends AppController {

	@FXML
	private Button botonGuardar;

	@FXML
	private Label labelEdad;

	@FXML
	private Label labelNombre;

	@FXML
	private TextField textFieldEdad;

	@FXML
	private TextField textFieldNombre;

	private Animal animal;

	@FXML
	void presionarGuardar(ActionEvent event) {
		try {

			animal.setEdad(Integer.parseInt(textFieldEdad.getText()));
			animal.setNombre(textFieldNombre.getText());

			animal.validarTodo();
			AnimalesServices animalesServices = new AnimalesServices();
			animalesServices.addAnimal(animal);

			TablaController controller = (TablaController) changeScene(FXML_TABLA);

			controller.consultar(animal.getTipo());
		} catch (NumberFormatException e) {
			mostrarPop("La edad no puede ser vacía y tiene que ser un número");

		} catch (AnimalDataNotValidException e) {
			mostrarPop(e.getMessage());
		}

	}

	@FXML
	public void initialize() {
		animal = (Animal) getParam(PARAM_ANIMAL);
	}

}
