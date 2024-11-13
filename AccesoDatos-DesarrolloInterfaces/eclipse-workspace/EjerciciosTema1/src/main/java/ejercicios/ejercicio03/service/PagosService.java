package ejercicios.ejercicio03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicios.ejercicio01.services.Service;
import ejercicios.ejercicio02.dao.ClientesDao;
import ejercicios.ejercicio02.modelo.Cliente;
import ejercicios.ejercicio03.dao.PagosDao;
import ejercicios.ejercicio03.modelo.Pago;

public class PagosService extends Service{

	private ClientesDao clientesDao;
	private PagosDao pagosDao;
	
	public PagosService() {
		clientesDao = new ClientesDao();
		pagosDao = new PagosDao();
	}
	
	public Map<String, List<Pago>> consultarPagosClientes() throws PagosException{
		try (Connection conn = abrirConexionSakila()){
			Map<String, List<Pago>> mapa = new HashMap<String, List<Pago>>();
			
			// 1. Obtener lista de clientes de ClienteDao
			List<Cliente> clientes = clientesDao.consultarClientes(conn);
			// 2. Recorrer la lista de clientes
			for (Cliente cliente : clientes) {
				// 4. Por cada cliente --> Llamar a PagosDao y obtener su lista de pagos
				List<Pago> pagos = pagosDao.consultarPagos(conn, cliente.getId());
				// 5. Meter en el mapa el email del cliente + su lista de pagos
				mapa.put(cliente.getEmail(), pagos);
			}
			return mapa;
		}
		catch(SQLException e) {
			System.err.println("Error al obtener pagos de clientes de bbdd");
			throw new PagosException("Error al obtener pagos de cliente", e);
		}
	}
}
