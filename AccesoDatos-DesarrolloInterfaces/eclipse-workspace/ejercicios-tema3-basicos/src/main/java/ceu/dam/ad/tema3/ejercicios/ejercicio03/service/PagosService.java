package ceu.dam.ad.tema3.ejercicios.ejercicio03.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.repository.ClientesRepository;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.model.Pago;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.repository.PagosRepository;

@Service
public class PagosService {
	@Autowired
	private PagosRepository pagosRepository;
	@Autowired
	private ClientesRepository repository;

	private static final Logger log = LoggerFactory.getLogger(PagosService.class);

	public Map<String, List<Pago>> consultarPagosClientes() throws PagosException {
		try (Connection conn = null) {
			Map<String, List<Pago>> mapa = new HashMap<>();

			List<Cliente> clientes = repository.findAll();

			for (Cliente cliente : clientes) {

				List<Pago> pagos = pagosRepository.findByCustomerIdEquals(cliente.getId());

				mapa.put(cliente.getEmail(), pagos);
			}
			return mapa;
		} catch (SQLException e) {
			System.err.println("Error al obtener pagos de clientes de bbdd");
			throw new PagosException("Error al obtener pagos de cliente", e);
		}
	}
}
