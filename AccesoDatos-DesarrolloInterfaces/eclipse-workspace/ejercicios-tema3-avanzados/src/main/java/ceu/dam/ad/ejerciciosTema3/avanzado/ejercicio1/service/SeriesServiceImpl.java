package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.model.Serie;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.repository.SeriesRepository;
@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository repository;

	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {

		try {
			Optional<Serie> serieOpt = repository.findById(idSerie);
			if (!serieOpt.isPresent()) {
				throw new SerieNotFoundException("No existe serie con id " + idSerie);
			}

			Serie serie = serieOpt.get();
			return serie;

		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al registrar la serie", e);
		}
	}

	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		try {
			List<Serie> series = repository.findByDescripcionContaining(filtroDescripcion);
			if (series.isEmpty()) {
				throw new SerieNotFoundException("No existe serie con " + filtroDescripcion);
			}
			return series;

		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al registrar la serie", e);
		}

	}


	@Override
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		try {
			
			return repository.save(serie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al registrar la serie", e);
		}

	}

	@Override
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		try {
			
			repository.deleteById(idSerie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al registrar la serie", e);
		}

	}

	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		try {
			
			repository.save(serie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al registrar la serie", e);
		}
	}

}
