package ceu.dam.ad.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ceu.dam.ad.users.model.Autor;

@Service
public interface AutoresService {

	
	/** El método recibe una lista de autores con todos sus datos rellenos.
	 * Tendrá que guardar todos los autores en base de datos, y todas sus entidades asociadas.
	 * Si hay algún error al guardar algún autor, no se guardará ninguno (se deshace la transacción completa)
	 * Si hay algún error, lanzará AutorServiceException
	 */
	public void guardarAutores (List<Autor> autores) throws AutorServiceException;

	
	
	/** El método recibe un identificador de autor. Tendrá que consultarlo en base de datos
	 * y devolver un objeto Autor con todas sus entidades completas.
	 * Si no existe el autor con ese ID, lanzará AutorNotFoundException.
	 * Si hay algún error, lanzará AutorServiceException
	 */
	public Autor consultarAutor (Long id) throws AutorNotFoundException, AutorServiceException;


}
