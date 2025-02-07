package app.gui;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ClienteApiServiceApi;
import org.openapitools.client.api.PedidosApiServiceApi;

import ceu.dam.ad.mongo.api.PedidosApiService;
import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.model.Pedido;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AltaClienteController extends AppController {

	@FXML
	private Button botonCrear;

	@FXML
	private TextField textFieldDNI;

	@FXML
	private TextField textFieldDireccion;

	@FXML
	private TextField textFieldNombre;

	@FXML
	public void crearCliente(ActionEvent event) {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");

		ClienteApiServiceApi clienteApiServiceApi = new ClienteApiServiceApi(client);

		try {
			
			

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}