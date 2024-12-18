package ceu.dam.ad.tema3.ejercicios.ejercicio02.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.repository.ClientesRepository;

@Service
public class ClienteService {
	@Autowired
	private ClientesRepository repository;

	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

	public Map<String, Cliente> consultarMapaClientes() throws ClientesException, SQLException {
		try (Connection conn = null) {

			log.info("Consultado clientes");

			List<Cliente> clientes = repository.findAll();
			return clientes.stream().collect(Collectors.toMap(Cliente::getEmail, c -> c));

		} catch (DataAccessException e) {
			log.error("Error consultando el cliente" + e);
			throw new ClientesException("Error al consultar cliente en BBDD", e);
		}
	}

}
