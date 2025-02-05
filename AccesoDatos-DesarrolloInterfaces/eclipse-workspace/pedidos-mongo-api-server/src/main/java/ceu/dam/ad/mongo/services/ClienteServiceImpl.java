package ceu.dam.ad.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente crearCliente(Cliente cliente) throws DatosIncorrectosException {

		try {

			if (!clienteRepository.findByDni(cliente.getDni()).isEmpty()) {
				throw new DatosIncorrectosException("Error cliente ya registrado");
			}
			return clienteRepository.save(cliente);

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) throws DatosIncorrectosException {
		try {

			if (cliente.getId().isEmpty()) {

				if (clienteRepository.findByDni(cliente.getDni()).isEmpty()) {
					throw new DatosIncorrectosException("Error cliente no encontrado ");
				}
				return clienteRepository.save(cliente);
			}

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}
		return null;

	}

	@Override
	public Cliente consultarClienteById(String id) throws DatosIncorrectosException {
		try {

			Optional<Cliente> clienteOpt = clienteRepository.findById(id);

			if (!clienteOpt.isPresent()) {
				throw new DatosIncorrectosException("Error cliente no encontrado ");
			}
			return clienteOpt.get();
		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}

	}

	@Override
	public Cliente consultarClienteByDni(String dni) throws DatosIncorrectosException {

		try {
			List<Cliente> clientes = clienteRepository.findByDni(dni);
			if (clientes.isEmpty()) {
				throw new DatosIncorrectosException("Error cliente no encontrado ");
			}
			return clientes.getFirst();

		} catch (DataAccessException e) {
			throw new DatosIncorrectosException("Error al registrar los cliente", e);
		}

	}

}
