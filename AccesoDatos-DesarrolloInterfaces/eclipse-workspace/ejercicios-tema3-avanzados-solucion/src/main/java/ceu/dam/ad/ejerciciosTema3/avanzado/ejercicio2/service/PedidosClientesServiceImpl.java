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
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private ArticuloRepository articuloRepo;
	
	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			clienteRepo.save(cliente);
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error creando cliente", e);
		}
	}


	@Override
	@Transactional
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {
			Optional<Cliente> cliente = clienteRepo.findById(pedido.getCliente().getDni());
			if (!cliente.isPresent()) {
				throw new PedidosClientesServiceException("El cliente del pedido no existe");
			}
			
			for (int i = 0; i<pedido.getLineas().size(); i++) {
				PedidoLinea pedidoLinea = pedido.getLineas().get(i);
				Long idArticulo = pedidoLinea.getArticulo().getId();
				pedidoLinea.setNumLinea(i+1);
				if (!articuloRepo.findById(idArticulo).isPresent()) {
					throw new PedidosClientesServiceException("No existe artículo incluido en el pedido con ID " + idArticulo);
				}
			}
			return pedidoRepo.save(pedido);
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error creando pedido", e);
		}
	}


	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		try {
			return articuloRepo.save(articulo);
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error creando artículo", e);
		}
	}
	
	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			consultarCliente(cliente.getDni());
			clienteRepo.save(cliente);
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error actualizando cliente", e);
		}
		catch(NotFoundException e) {
			throw new PedidosClientesServiceException("No existe cliente con el dni indicado", e);
		}
	}


	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		try {
			Optional<Cliente> cliente = clienteRepo.findById(dni);
			if (!cliente.isPresent()) {
				throw new NotFoundException("El cliente indicado no existe");
			}
			return cliente.get();
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error consultando cliente", e);
		}
	}


	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		try {
			Optional<Articulo> articulo = articuloRepo.findById(idArticulo);
			if (!articulo.isPresent()) {
				throw new NotFoundException("El artículo indicado no existe");
			}
			return articulo.get();
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error consultando artículo", e);
		}
	}


	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		try {
			Optional<Pedido> pedido = pedidoRepo.findById(UUID.fromString(uuid));
			if (!pedido.isPresent()) {
				throw new NotFoundException("El pedido indicado no existe");
			}
			return pedido.get();
		}
		catch(DataAccessException e) {
			throw new PedidosClientesServiceException("Error consultando pedido", e);
		}
	}
	
	
	
}
