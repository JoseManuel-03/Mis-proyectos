package ceu.dam.ad.tema3.ejercicios.ejercicio01.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.repository.PeliculasRepository;

@Service
public class PeliculasService {
	@Autowired
	private PeliculasRepository repository;

	private static final Logger log = LoggerFactory.getLogger(PeliculasService.class);

	public List<Pelicula> consultarPeliculas() throws PeliculasException {
		try {
			log.info("Consultado peliculas");
			return repository.findAll();
		} catch (DataAccessException e) {
			log.error("Error consultando peliculas" + e);
			throw new PeliculasException();
		}

	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasException {
		try {
			log.info("Consultado peliculas menores de la longitud dada");
			return repository.findByLongitudIsLessThan(longitud);
		} catch (DataAccessException e) {
			log.error("Error consultando peliculas" + e);
			throw new PeliculasException();
		}
	}

}
