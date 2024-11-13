package ejercicios.ejercicio04.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejercicios.ejercicio01.services.Service;
import ejercicios.ejercicio04.dao.PedidoDao;
import ejercicios.ejercicio04.dao.PedidoLineaDao;
import ejercicios.ejercicio04.modelo.Pedido;
import ejercicios.ejercicio04.modelo.PedidoLinea;

public class PedidosService extends Service{

	private static final Logger log = LoggerFactory.getLogger(PedidosService.class);
	
	private PedidoDao daoPedido;
	private PedidoLineaDao daoLinea;

	public PedidosService() {
		daoPedido = new PedidoDao();
		daoLinea = new PedidoLineaDao();
	}

	public Pedido consultarPedido(Long idPedido) throws PedidoException, PedidoNotFoundException {
		log.debug("Consultando pedido con id " + idPedido);
		try (Connection conn = abrirConexionPedidos()){
			Pedido pedido = daoPedido.consultar(conn, idPedido);
			if (pedido == null) {
				log.warn("No se ha encontrado el pedido con id " + idPedido);
				throw new PedidoNotFoundException("No existe pedido con id " + idPedido);
			}
			pedido.setLineas(daoLinea.consultar(conn, idPedido));
			return pedido;
		}
		catch(SQLException e) {
			log.error("Error registrando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}
	
	public Long crearPedido(Pedido pedido) throws PedidoException {
		log.debug("Creando nuevo pedido....");
		try (Connection conn = abrirConexionPedidos()){
			conn.setAutoCommit(false);
			try {
				log.debug("Insertando datos generales del pedido...");
				Long idPedido = daoPedido.insertar(conn, pedido);
				Integer numLinea = 1;
				log.debug("Insertando líneas del pedido...");
				for (PedidoLinea linea : pedido.getLineas()) {
					linea.setIdPedido(idPedido);
					linea.setNumLinea(numLinea);
					numLinea++;
					daoLinea.insertar(conn, linea);
				}
				// Opción con FOR normal
//				for (int i = 0; i < pedido.getLineas().size(); i++) {
//					pedido.getLineas().get(i).setIdPedido(idPedido);
//					pedido.getLineas().get(i).setNumLinea(i);
//					daoLinea.insertar(conn, pedido.getLineas().get(i));
//				}
				
				conn.commit();
				log.info("Pedido registrado con id " + idPedido);
				return idPedido;
			}
			catch(SQLException e) {
				conn.rollback();
				throw e;
			}
		}
		catch(SQLException e) {
			log.error("Error creando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}
	
}
