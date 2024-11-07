package Ejercicio2.app;

import java.util.Map;

import Ejercicio2.modelo.Cliente;
import Ejercicio2.services.NoHayClientesException;
import Ejercicio2.services.Services;


public class App {

	public static void main(String[] args) {
		
		Services connection = new Services();
		try {
			Map<String, Cliente> mapa = connection.consultarCliente();
			
			String emailBuscado = "MARILYN.ROSS@sakilacustomer.org";
			Cliente cliente = mapa.get(emailBuscado);
			System.out.println(cliente);
			
		} catch(NoHayClientesException e) {
			e.printStackTrace();
		}
		
	}

}
