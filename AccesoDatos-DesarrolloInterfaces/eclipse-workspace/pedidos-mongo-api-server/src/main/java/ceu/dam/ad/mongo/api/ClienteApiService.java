package ceu.dam.ad.mongo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.services.ClienteServiceImpl;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;

@RestController
public class ClienteApiService {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@PostMapping("/cliente")
	public Cliente crearClient(@RequestBody Cliente cliente) throws DatosIncorrectosException {
		return clienteServiceImpl.crearCliente(cliente);
	}
	@PutMapping("/cliente")
	public Cliente actualizarClient(@RequestBody Cliente cliente) throws DatosIncorrectosException {
		return clienteServiceImpl.actualizarCliente(cliente);
	}
	@GetMapping("/cliente/{id}")
	public Cliente consularPorId(@PathVariable String id) throws DatosIncorrectosException {
		return clienteServiceImpl.consultarClienteById(id);
	}

	@GetMapping("/cliente")
	public Cliente consultarPorDni(@RequestParam String dni) throws DatosIncorrectosException {
		return clienteServiceImpl.consultarClienteByDni(dni);
	}

}
