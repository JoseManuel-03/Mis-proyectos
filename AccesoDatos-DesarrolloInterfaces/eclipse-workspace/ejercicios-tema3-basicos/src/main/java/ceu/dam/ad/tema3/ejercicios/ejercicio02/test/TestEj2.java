package ceu.dam.ad.tema3.ejercicios.ejercicio02.test;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.service.ClienteService;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.service.ClientesException;

@Component
public class TestEj2 {
	@Autowired

	private ClienteService clienteService;

	public void test() throws SQLException {
		try {
			Map<String, Cliente> clientes = clienteService.consultarMapaClientes();
			Cliente cliente = clientes.get("MARILYN.ROSS@sakilacustomer.org");
			System.out.println(cliente);

		} catch (ClientesException e) {
			e.printStackTrace();
		}
	}

}
