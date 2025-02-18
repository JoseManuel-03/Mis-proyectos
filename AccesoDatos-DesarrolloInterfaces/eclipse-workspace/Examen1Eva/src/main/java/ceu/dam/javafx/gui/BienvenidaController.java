package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BienvenidaController extends AppController{
	
	@FXML
    private Button botonAcceder;

    @FXML
    private Button botonSalir;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private TextField textField;

    @FXML
    void presionarAcceder(ActionEvent event) {
    }

    @FXML
    void presionarSalir(ActionEvent event) {
    	System.exit(0);
    }

	

}
