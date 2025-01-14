package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.service;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

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

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {

			if (cliente.getPedidos() != null) {
				cliente.setPedidos(null);
			}

			clienteRepository.save(cliente);

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}

	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {

			repository.save(pedido);
			Integer numLinea = 1;

			for (PedidoLinea linea : pedido.getLineas()) {
				linea.setUidLinea(pedido.getUidPedido());
				linea.setNumLinea(numLinea);
				numLinea++;
				lineaRepository.save(linea);
			}

			return pedido;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}


	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		try {

			articuloRepository.save(articulo);
			return articulo;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}



	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {

			clienteRepository.save(cliente);

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
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


			for (Pedido pedidos : cliente.getPedidos()) {
				pedidos.getLineas();
			}

			return cliente;

		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
		}
	}

	/**
	 * Consulta el articulo con el ID indicado en BBDD. Si no existe, lanza
	 * NotFoundException Si existe, devolverá dicho artículo.
	 */

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
			throw new PedidosClientesServiceException("Error al registrar los pedidos", e);
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
			
			Optional<Pedido> pedidoOpt = repository.findByUidPedido(uuid);
			
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
