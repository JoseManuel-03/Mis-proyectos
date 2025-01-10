package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Articulo;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Cliente;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Pedido;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.PedidoRepository;

@Service
public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Autowired
	private PedidoRepository repository;

	/**
	 * Debe crear en bbdd el cliente indicado. Si el cliente incorpora una lista de
	 * pedidos, estos no deben de registrarse en la BBDD.
	 */

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {

			repository.save(cliente);
		} catch (DataAccessException e) {
		}
	}

	/**
	 * Debe crear en bbdd el pedido indicado. En el pedido, el cliente tiene que
	 * estar previamente registrado, así como los artículos de las líneas. Al
	 * guardar el pedido, guardaremos también todas sus líneas. Devolverá el pedido
	 * registrado completo. IMPORTANTE: todas las l�neas del pedido habrá que
	 * inicializarlas con su n�mero de línea antes de guardarlas. Se inicializarán
	 * comenzando en 1
	 */
	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {

			return repository.save(pedido);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		try {

			return repository.save(articulo);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
	}

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

}
