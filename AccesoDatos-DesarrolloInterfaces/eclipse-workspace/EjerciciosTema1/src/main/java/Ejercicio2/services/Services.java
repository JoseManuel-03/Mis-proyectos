package Ejercicio2.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import Ejercicio2.modelo.Cliente;

public class Services extends Conexion {
	
	private Dao dao;

	public Services() {
		dao = new Dao();
	}
	
	public Map<String, Cliente> consultarCliente() throws NoHayClientesException{
		try (Connection conn = abrirConexion()){
			return dao.buscar(conn).stream().collect(Collectors.toMap(e->e.getEmail(), e->e)) ;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoHayClientesException("Error con excepciones", e);
		}
		
	}
	
	

}
