package ceu.dam.javafx.practica1.login;

import java.text.SimpleDateFormat;


import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.UserApiServiceApi;
import org.openapitools.client.model.CreateUserRequest;
import org.openapitools.client.model.User;

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
	public void entrar(ActionEvent event) throws LoginDenegadoException {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		client.setApiKey("pass");

		UserApiServiceApi api = new UserApiServiceApi(client);

		try {
			User user = api.loginUsuario(txfUsuario.getText(), passfContraseña.getText());
			System.out.println(user);			

			if (user == null) {
				labelUusario.setText("ACCESO DENEGADO");

			} 
			changeScene(FXML_MENU);
		} catch (ApiException e) {
			labelUusario.setText("ACCESO DENEGADO"+ "\t \t \t"+e.getLocalizedMessage());
			System.out.println(e.getCode());
			System.out.println(e.getLocalizedMessage());
		}

		
		
		
	}

	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}

}
