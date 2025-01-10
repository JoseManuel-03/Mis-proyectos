package ceu.dam.javafx.practica1.htmlEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class HtmlEditor {

	@FXML
	private Button botonLeer;

	@FXML
	private HTMLEditor htmlEditor;

	@FXML
	private TextField textField;

	@FXML
	void leerHtml(ActionEvent event) {
		textField.setText(htmlEditor.getHtmlText());
	}

}
