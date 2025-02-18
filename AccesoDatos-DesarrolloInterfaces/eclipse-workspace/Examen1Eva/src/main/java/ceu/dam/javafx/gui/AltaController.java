package ceu.dam.javafx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AltaController extends AppController{
	
	@FXML
    private Button boton0;

    @FXML
    private Button boton1;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonSalir;

    @FXML
    private Button botonSalvar;

    @FXML
    private RadioButton radiobutonCodigo;

    @FXML
    private RadioButton radiobutonOtros;

    @FXML
    private RadioButton radiobutonProgramacion;

    @FXML
    private TextField textFieldBinario;

    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TextField textFieldOtros;

    @FXML
    void initialize() {
    	textFieldOtros.setDisable(false);
    	textFieldBinario.setText("");
    	textFieldDescripcion.setText("");
    	textFieldOtros.setText("");
    }
    
    @FXML
    void presionar1(ActionEvent event) {
    	textFieldBinario.setText(textFieldBinario.getText() + "1");
    }

    @FXML
    void presionarBorrar(ActionEvent event) {
    	textFieldBinario.setText(textFieldBinario.getText().substring(0, textFieldBinario.getLength() - 1));
    }

    @FXML
    void presionarBoton0(ActionEvent event) {
    	textFieldBinario.setText(textFieldBinario.getText() + "0");
    }
    

    @FXML
    void presionarOtros(ActionEvent event) {
    	textFieldOtros.setDisable(true);
    }
	    

	    @FXML
	    void presionarSalir(ActionEvent event) {
	    	changeScene(FXML_BIENVENIDA);
	    }

	    @FXML
	    void presionarSalvar(ActionEvent event) {
	    	
	    }

	
}
