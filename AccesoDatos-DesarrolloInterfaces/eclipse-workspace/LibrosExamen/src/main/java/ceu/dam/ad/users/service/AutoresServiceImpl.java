package ceu.dam.ad.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.users.model.Autor;
import ceu.dam.ad.users.repository.AutorRepository;
import jakarta.transaction.Transactional;

@Service
public class AutoresServiceImpl implements AutoresService {

	@Autowired
	private AutorRepository autorRepository;

	/**
	 * El método recibe una lista de autores con todos sus datos rellenos. Tendrá
	 * que guardar todos los autores en base de datos, y todas sus entidades
	 * asociadas. Si hay algún error al guardar algún autor, no se guardará ninguno
	 * (se deshace la transacción completa) Si hay algún error, lanzará
	 * AutorServiceException
	 */
	@Override
	@Transactional
	public void guardarAutores(List<Autor> autores) throws AutorServiceException {
		try {
			for (Autor autor : autores) {
				if (autor.getNombre() == null) {
					throw new AutorServiceException("El nombre no puede ser nulo");
				}
				autorRepository.save(autor);
			}

		} catch (DataAccessException e) {
			throw new AutorServiceException();
		}

	}

	/**
	 * El método recibe un identificador de autor. Tendrá que consultarlo en base de
	 * datos y devolver un objeto Autor con todas sus entidades completas. Si no
	 * existe el autor con ese ID, lanzará AutorNotFoundException. Si hay algún
	 * error, lanzará AutorServiceException
	 */
	@Override
	public Autor consultarAutor(Long id) throws AutorNotFoundException, AutorServiceException {
		try {

			Optional<Autor> autorOpt = autorRepository.findById(id);

			if (!autorOpt.isPresent()) {
				throw new AutorNotFoundException();
			}

		} catch (DataAccessException e) {
			throw new AutorServiceException();
		}
		return null;
	}

}
