package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.model.Serie;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.repository.SerieRepository;
import jakarta.transaction.Transactional;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SerieRepository repository;
	
	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {
		try {
			Optional<Serie> serie = repository.findById(idSerie);
			if (!serie.isPresent()) {
				throw new SerieNotFoundException("No existe serie con el id indicado: "+ idSerie);
			}
			return serie.get();
		}
		catch(DataAccessException e) {
			throw new SeriesServiceException("Error consultando serie", e);
		}
	}
	
	
	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		try {
			List<Serie> series = repository.findByDescripcionContains(filtroDescripcion);
			if (series.isEmpty()) {
				throw new SerieNotFoundException("No existen series con el filtro indicado: "+ filtroDescripcion);
			}
			return series;
		}
		catch(DataAccessException e) {
			throw new SeriesServiceException("Error consultando serie", e);
		}
		
	}
	
	@Override
	@Transactional
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		try {
			return repository.save(serie);
		}
		catch(DataAccessException e) {
			throw new SeriesServiceException("Error creando serie", e);
		}
		
	}
	
	
	@Override
	@Transactional
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		try {
			repository.deleteById(idSerie);
		}
		catch(DataAccessException e) {
			throw new SeriesServiceException("Error eliminando serie", e);
		}
		
	}
	
	
	@Override
	@Transactional
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		try {
			repository.save(serie);
		}
		catch(DataAccessException e) {
			throw new SeriesServiceException("Error actualizando serie", e);
		}
		
	}
	
	
}
