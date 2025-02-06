package ceu.dam.ad.mongo.api;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import ceu.dam.ad.mongo.services.PedidoServiceImpl;

@RestController
public class PedidosApiService {

	@Autowired
	private PedidoServiceImpl pedidoServiceImpl;

	@PostMapping("/pedido")
	public String crearPedido(@RequestBody Pedido pedido) throws DatosIncorrectosException {
		return pedidoServiceImpl.registrarPedido(pedido);

	}

	@GetMapping("/pedido/{id}")
	public Pedido consultarPedido(@PathVariable String id) throws DatosIncorrectosException {
		return pedidoServiceImpl.consultarPedido(id);

	}

	@GetMapping("/pedido/fechas")
	public List<Pedido> consultarPedidoFechas(@RequestParam LocalDate desde, @RequestParam LocalDate hasta) {
		return pedidoServiceImpl.buscarPedidos(desde, hasta);

	}

	@GetMapping("/pedido")
	public List<Pedido> consultarPedidosCliente(@RequestParam String dni) {
		return pedidoServiceImpl.consultarPedidosCliente(dni);

	}

	@PutMapping("/pedido")
	public Pedido añadirDetalles(@RequestParam String id, @RequestParam PedidoDetalle detalle)
			throws DatosIncorrectosException {
		return pedidoServiceImpl.añadirDetalle(id, detalle);
	}

}
