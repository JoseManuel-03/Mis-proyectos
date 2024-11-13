package ejercicios.ejercicio02.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ejercicios.ejercicio01.services.Service;
import ejercicios.ejercicio02.dao.ClientesDao;
import ejercicios.ejercicio02.modelo.Cliente;

public class ClienteService extends Service{

	private ClientesDao dao;
	
	public ClienteService() {
		dao = new ClientesDao();
	}
	
	
	public Map<String, Cliente> consultarMapaClientes() throws ClientesException{
		try (Connection conn = abrirConexionSakila()){
			List<Cliente> clientes = dao.consultarClientes(conn);
			return clientes.stream().collect(Collectors.toMap(Cliente::getEmail, c->c));
		}
		catch(SQLException e) {
			System.err.println("Error al consultar cliente");
			throw new ClientesException("Error al consultar cliente en BBDD", e);
		}
	}

}
