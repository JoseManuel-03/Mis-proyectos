package Ejercicio4.Services;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ejercicio4.Dao.Conexion;
import Ejercicio4.Dao.DaoLineaPedido;
import Ejercicio4.Dao.DaoPedido;
import Ejercicio4.Dao.DaoUser;
import Ejercicio4.Dao.NoHayPeidosException;
import Ejercicio4.Interfaz.Interface;
import Ejercicio4.Modelo.LineaPedido;
import Ejercicio4.Modelo.Pedido;
import Ejercicio4.Modelo.Usuario;

public class PedidosService extends Conexion {

	private static final Logger log = LoggerFactory.getLogger(PedidosService.class);

	private DaoPedido daoPedido;
	private DaoLineaPedido daoLineaPedido;
	

	public PedidosService() {
		daoPedido = new DaoPedido();
		daoLineaPedido = new DaoLineaPedido();

	}

	public Long crearPedido(Pedido pedido) throws NoHayPeidosException, SQLException {
		log.debug("Creando nuevo pedido...");
		Connection conn = abrirConexion();
		try {
			log.debug("Insertando..");
			conn.setAutoCommit(false);

			Long idPedido = daoPedido.insertarPedidos(conn, pedido);
			Integer numLinea = 1;
			log.debug("Insertando lineas de pedido");
			for (LineaPedido linea : pedido.getLista()) {
				linea.setIdPedido(idPedido);
				linea.setNumeroLinea(numLinea);
				numLinea++;
				daoLineaPedido.insertarLineaPedidos(conn, linea);
			}

			daoPedido.insertarPedidos(conn, pedido);

			conn.commit();

			return idPedido;

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw new NoHayPeidosException("Error con excepciones", e);
		}

	}

	public void crearLineaPedido(LineaPedido linea) throws NoHayPeidosException, SQLException {
		Connection conn = abrirConexion();
		try {

			conn.setAutoCommit(false);

			daoLineaPedido.insertarLineaPedidos(conn, linea);

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw new NoHayPeidosException("Error con excepciones", e);
		}

		conn.commit();

	}

	public Pedido consultarPedido(Long idPedido) throws NoHayPeidosException {
		try (Connection conn = abrirConexion()) {
			Pedido pedido = daoPedido.consultarPedidos(conn, idPedido);
			if (pedido == null) {
				throw new NoHayPeidosException("No existe pedido con id " + idPedido);
			}
			pedido.setLista(daoLineaPedido.consultarLineaPedidos(conn, idPedido));
			return pedido;
		} catch (SQLException e) {
			log.error("Error registrando pedido", e);
			throw new NoHayPeidosException("Error al registrar pedido", e);
		}
	}

}
