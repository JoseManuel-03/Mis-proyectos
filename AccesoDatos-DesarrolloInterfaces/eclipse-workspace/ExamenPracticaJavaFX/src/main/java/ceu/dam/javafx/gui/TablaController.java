package ceu.dam.javafx.gui;

import java.util.List;


import ceu.dam.javafx.gui.services.AnimalesNotFoundException;
import ceu.dam.javafx.gui.services.AnimalesServices;
import ceu.dam.javafx.modelo.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;

public class TablaController extends AppController {

	private MenuController controller;

	private Animal animal;

	@FXML
	private Button botonConsultar;

	@FXML
	private Button botonNuevo;

	@FXML
	private ProgressBar progressBar;

	@FXML
	private TableColumn<Animal, Integer> columnaEdad;

	@FXML
	private TableColumn<Animal, String> columnaNombre;

	@FXML
	private TableColumn<Animal, String> columnaTipo;

	@FXML
	private TableView<Animal> tabla;

	@FXML
	private TextField textField;

	private ObservableList<Animal> datos;

	@FXML
	public void initialize() {
		columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		datos = FXCollections.observableArrayList();
		tabla.setItems(datos);
	}

	@FXML
	void presionarConsultar(ActionEvent event) throws AnimalesNotFoundException {
		consultar(textField.getText());
	}

	public void consultar(String texto) {
		textField.setText(texto);
		AnimalesServices animalesServices = new AnimalesServices();

		Task<List<Animal>> task = new Task<List<Animal>>() {

			@Override
			protected List<Animal> call() throws Exception {
				return animalesServices.consultarAnimales(texto);
			}

			@Override
			protected void succeeded() {
				tabla.setEffect(null);
				datos.setAll(getValue());
				updateProgress(100, 100);
			}

			@Override
			protected void failed() {
				tabla.setEffect(null);
				datos.clear();
				mostrarPop(getException().getMessage());
				updateProgress(100, 100);
			}
		};

		progressBar.progressProperty().bind(task.progressProperty());

		tabla.setEffect(new BoxBlur());
		new Thread(task).start();
	}
	
	@FXML
    void presionarNuevo(ActionEvent event) {

    }

}
