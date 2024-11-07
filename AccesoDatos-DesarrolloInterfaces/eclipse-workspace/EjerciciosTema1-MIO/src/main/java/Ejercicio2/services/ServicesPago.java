package Ejercicio2.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Ejercicio2.modelo.Cliente;
import Ejercicio2.modelo.Pago;

public class ServicesPago extends Conexion  {
	
	private Dao dao;
	private DaoPago daoPago;

	public ServicesPago() {
		dao = new Dao();
		daoPago = new DaoPago();
	}
	
	
	
	public Map<String, List<Pago>> consultarPago() throws NoHayClientesException{
		try (Connection conn = abrirConexion()){
			Map<String, List<Pago>> mapa = new HashMap<String, List<Pago>>();
			
			// 1. Obtener lista de clientes de ClienteDao
			List<Cliente> clientes = dao.buscar(conn);
			// 2. Recorrer la lista de clientes
			for (Cliente cliente : clientes) {
				// 4. Por cada cliente --> Llamar a PagosDao y obtener su lista de pagos
				List<Pago> pagos = daoPago.buscar(conn, cliente.getId());
				// 5. Meter en el mapa el email del cliente + su lista de pagos
				mapa.put(cliente.getEmail(), pagos);
			}
			return mapa;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoHayClientesException("Error con excepciones", e);
		}
	
		
	}

}
