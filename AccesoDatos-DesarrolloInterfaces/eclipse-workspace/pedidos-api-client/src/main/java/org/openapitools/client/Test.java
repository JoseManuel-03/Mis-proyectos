package org.openapitools.client;

import org.openapitools.client.api.ClienteApiServiceApi;
import org.openapitools.client.api.PedidosApiServiceApi;
import org.openapitools.client.model.Cliente;
import org.openapitools.client.model.Pedido;

public class Test {

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8080");
		
		ClienteApiServiceApi clienteApiServiceApi = new ClienteApiServiceApi(apiClient);
		PedidosApiServiceApi pedidosApiServiceApi = new PedidosApiServiceApi(apiClient);
		
		try {
			
			Cliente cliente = clienteApiServiceApi.consularPorId(null);
			System.out.println(cliente);
			
			Pedido pedido = pedidosApiServiceApi.consultarPedido(null);
			System.out.println(pedido);
			
			
		} catch (ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getLocalizedMessage());
		}

	}

}
