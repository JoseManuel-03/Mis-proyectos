package ceu.dam.ad.users.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.model.Autor;
import ceu.dam.ad.users.service.AutorNotFoundException;
import ceu.dam.ad.users.service.AutorServiceException;
import ceu.dam.ad.users.service.AutoresService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Authorization")
public class LibroApiService {

	@Autowired
	private AutoresService autoresService;

	@GetMapping("/libros/{id}")
	public Autor consultar(@PathVariable Long id) throws AutorNotFoundException, AutorServiceException {
		return autoresService.consultarAutor(id);

	}
	
	@PostMapping("/libros")
	public void insertar(@Valid @RequestBody List<Autor> autores) throws AutorServiceException {
		autoresService.guardarAutores(autores);
	}

}
