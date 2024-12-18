package ceu.dam.javafx.practica1.login;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import ceu.dam.javafx.practica1.app.AppController;
import ceu.dam.javafx.practica1.modelo.Usuario;
import ceu.dam.javafx.practica1.services.LoginDenegadoException;
import ceu.dam.javafx.practica1.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController extends AppController {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private LoginService service;
	private Usuario user;

	@FXML
	private ImageView image;

	@FXML
	private Label labelBienvenido;

	@FXML
	private Label labelUusario;

	@FXML
	private TextField txfUsuario;
	
	@FXML
	private PasswordField passfContraseña;
	

	@FXML
	public void entrar(ActionEvent event) {
		try {
			service = new LoginService();
			user = service.login(txfUsuario.getText(), passfContraseña.getText());
			txfUsuario.setText("");
			passfContraseña.setText("");
			changeScene(FXML_MENU);
		} catch (LoginDenegadoException e) {
			e.getMessage();
		}

		if (user == null) {
			labelUusario.setText("ACCESO DENEGADO");

		} else {
			labelBienvenido.setText("BIENVENIDO MAESTRO");
			String fecha = sdf.format(user.getFechaRegistro());
			labelUusario.setText(user.getNombre() + " " + fecha);
			image.setVisible(true);
		}
	}

	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}
	


}
