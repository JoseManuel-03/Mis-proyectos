package ceu.dam.ad.api.ejemplo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.api.ejemplo.model.Coche;
import ceu.dam.ad.api.ejemplo.service.CocheNotFoundException;
import ceu.dam.ad.api.ejemplo.service.CocheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Authorization")
public class CocheApiService {

	@Autowired
	private CocheService service;

	
	@GetMapping("/coches/{id}")
	@Operation(summary = "Consulta de coches", description = "Consultar un coche a partir de su ID")
	public Coche consultar(@PathVariable Long id) throws CocheNotFoundException {
		return service.consultarCoche(id);
	}
	
	@GetMapping("/coches")
	@Operation(summary = "Busqueda de coches", description = "Buscar coches que contengan en su marca el filtro indicado")
	public List<Coche> buscar(@RequestParam(required = false)  String filtro) throws CocheNotFoundException {
		return service.buscarCoches(filtro);
	}

	@PostMapping("/coches")
	@Operation(summary = "Alta de coches", description = "Crear un coche y sus lista de conductores")
	public Coche crear(@Valid @RequestBody Coche coche) {
		return service.crearCoche(coche);
	}
	
	@PutMapping("/coches")
	@Operation(summary = "Actualización de coches", description = "Actualiza un coche y sus lista de conductores")
	public Coche actualizar(@Valid @RequestBody Coche coche) throws CocheNotFoundException {
		return service.actualizarCoche(coche);
	}
	
	@DeleteMapping("/coches/{id}")
	@Operation(summary = "Eliminación de coches", description = "Borra un coche y sus lista de conductores")
	public void borrar(@PathVariable Long id) throws CocheNotFoundException {
		service.borrarCoche(id);
	}
	
	
	
	
	
	
	
}
