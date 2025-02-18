package ceu.dam.javafx.practica3.gui;

import java.util.List;

import ceu.dam.javafx.practica3.modelo.Animal;
import ceu.dam.javafx.practica3.service.AnimalesNotFoundException;
import ceu.dam.javafx.practica3.service.AnimalesServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;

public class ConsultaController extends AppController {

	private AnimalesServices services;
	private Animal animal;

	@FXML
	private Button consultarBoton;

	@FXML
	private AnchorPane pane;

	@FXML
	private TableColumn<Animal, Integer> edadColumn;

	@FXML
	private TableColumn<Animal, String> nombreColumn;

	@FXML
	private TableColumn<Animal, String> tipoColumn;

	@FXML
	private TableView<Animal> tabla;

	@FXML
	private Button nuevoBoton;

	@FXML
	private TextField textFiled;

	@FXML
	private ProgressBar progressBar;

	private ObservableList<Animal> datos;

	@FXML
	public void presionarConsultar(ActionEvent event) {
		consultar(textFiled.getText());
	}

	public void consultar(String textoFiltro) {
		textFiled.setText(textoFiltro);
		services = new AnimalesServices();

		tabla.setEffect(new BoxBlur());

		Task<List<Animal>> task = new Task<List<Animal>>() {

			@Override
			protected List<Animal> call() throws Exception {
				return services.consultarAnimales(textoFiltro);
			};

			@Override
			protected void succeeded() {
				tabla.setEffect(null);
				List<Animal> resultado = getValue();
				datos.setAll(resultado);
				updateProgress(100, 100);

			};

			@Override
			protected void failed() {
				tabla.setEffect(null);
				datos.clear();
				mostrarPop(getException().getMessage());
				System.out.println(getException().getMessage());

			};
		};
		progressBar.progressProperty().bind(task.progressProperty());
		tabla.setEffect(new BoxBlur());
		new Thread(task).start();

	}

	@FXML
	void presionarNuevo(ActionEvent event) {
		changeScene(FXML_ALTA);
	}

	@FXML
	private void initialize() {
		edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
		nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		datos = FXCollections.observableArrayList();
		tabla.setItems(datos);

	}

}
