package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.service;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Articulo;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Cliente;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Pedido;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.PedidoLinea;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.ArticuloRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.ClienteRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.PedidoLineaRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.PedidoRepository;

@Service
public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private PedidoLineaRepository lineaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ArticuloRepository articuloRepository;

	/**
	 * Debe crear en bbdd el cliente indicado. Si el cliente incorpora una lista de
	 * pedidos, estos no deben de registrarse en la BBDD.
	 */
	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			
			clienteRepository.save(cliente);

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los clientes", e);
		}
	}

	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {

			clienteRepository.save(pedido.getCliente());
			Integer numLinea = 1;

			for (PedidoLinea linea : pedido.getLineas()) {
				linea.setUidLinea(pedido.getUidPedido());
				linea.setNumLinea(numLinea);
				numLinea++;
				lineaRepository.save(linea);
			}
			repository.save(pedido);

			return pedido;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}
	/**
	 * Debe crear en bbdd el artículo indicado. Devolverá el articulo registrado
	 * completo.
	 */
	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		try {

			articuloRepository.save(articulo);
			return articulo;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los articulos", e);
		}
	}

	/**
	 * Actualizará los datos del cliente indicado en BBDD. Sólo se actualizarán los
	 * datos de esta entidad, no de sus pedidos.
	 */
	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {

			clienteRepository.save(cliente);

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los cliente", e);
		}
	}

	/**
	 * Consulta el cliente con el DNI indicado en BBDD. Si no existe, lanza
	 * NotFoundException Si existe, devolverá dicho cliente con todos sus pedidos
	 * cargados.
	 */
	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		try {

			Optional<Cliente> clienteOpt = clienteRepository.findById(dni);

			if (!clienteOpt.isPresent()) {
				throw new NotFoundException("Error cliente no encontrado ");
			}
			Cliente cliente = clienteOpt.get();

			return cliente;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los cliente", e);
		}
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		try {

			Optional<Articulo> articuloOpt = articuloRepository.findById(idArticulo);

			if (!articuloOpt.isPresent()) {
				throw new NotFoundException("Error articulo no encontrado ");
			}
			Articulo articulo = articuloOpt.get();

			return articulo;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los articulos", e);
		}
	}

	/**
	 * Consulta el pedido con el uuid indicado. Si no existe, lanzará
	 * NotFoundExcepion. El pedido devuelto estará completo: con todas sus líneas,
	 * artículos y cliente.
	 */
	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {

		try {
			UUID uuidNuevo = UUID.fromString(uuid);
			Optional<Pedido> pedidoOpt = repository.findById(uuidNuevo);

			if (!pedidoOpt.isPresent()) {
				throw new NotFoundException("Error articulo no encontrado ");
			}
			Pedido pedido = pedidoOpt.get();

			for (PedidoLinea lineas : pedido.getLineas()) {
				lineas.getArticulo();
			}

			return pedido;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}

	}

}
