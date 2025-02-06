package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.repositories.CustomPedidoRepository;
import ceu.dam.ad.mongo.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException {
		try {

			List<Pedido> pedidoOpt = pedidoRepository.findByNumero(pedido.getNumero());

			if (!pedidoOpt.isEmpty()) {
				throw new DatosIncorrectosException("Error pedido ya encontrado ");
			}
			return pedidoRepository.save(pedido).getId();

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}
	}

	@Override
	public Pedido consultarPedido(String id) throws DatosIncorrectosException {
		try {

			Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);

			if (!pedidoOpt.isPresent()) {
				throw new DatosIncorrectosException("Error pedido no encontrado ");
			}
			return pedidoOpt.get();

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}
	}

	@Override
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta) {
		try {

			return pedidoRepository.findByFechaBetween(desde, hasta);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public List<Pedido> consultarPedidosCliente(String dni) {
		try {
			return pedidoRepository.buscarPorPedidosClientes(dni);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public Pedido añadirDetalle(String id, PedidoDetalle detalle) throws DatosIncorrectosException {
		try {

			Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);

			if (!pedidoOpt.isPresent()) {
				throw new DatosIncorrectosException("Error pedido no encontrado");
			}
			Pedido pedido = pedidoOpt.get();

			pedido.getDetalles().add(detalle);

			return pedidoRepository.save(pedido);

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}
	}

}
