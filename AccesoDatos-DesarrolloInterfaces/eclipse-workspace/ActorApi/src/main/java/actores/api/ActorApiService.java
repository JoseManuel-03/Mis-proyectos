package actores.api;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import actores.modelo.Actor;
import actores.services.ActorImpl;
import actores.services.ActorNotFound;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class ActorApiService {

	@Autowired
	private ActorImpl services;

	@GetMapping("/actor/{id}")
	@Operation(summary = "Consulta de actores", description = "Consultar un actor a partir de un ID")
	public Actor consultar(@PathVariable Long id) throws ActorNotFound {
		return services.consultarActor(id);

	}

	@PostMapping("/actor")
	@Operation(summary = "Crear actores", description = "Crear un actor")
	public Actor crear(@Valid @RequestBody Actor actor) {
		return services.crearActor(actor);

	}

	@PutMapping("/actor")
	@Operation(summary = "Actualizar actores", description = "Actualizar un actor")
	public Actor actualizar(@Valid @RequestBody Actor actor) throws ActorNotFound {
		return services.actualizarActor(actor);
                              
	}

	@DeleteMapping("/actor/{id}")
	@Operation(summary = "Borrar actores", description = "Borrar un actor a partir de un ID")
	public void borrar(@PathVariable Long id) throws ActorNotFound {
		services.borrarActor(id);

	}

	@GetMapping("/actor/nombreapellido")
	@Operation(summary = "Buscar de actores", description = "Consultar un actor a partir de un nombre/apellido")
	public List<Actor> buscarNombreApellido(@RequestParam String firstName, @RequestParam String lastName) {
		return services.buscarActorNombreApellidos(firstName, lastName);
	}

	@GetMapping("/actor")
	@Operation(summary = "Buscar de actores", description = "Consultar un actor a partir de una fecha")
	public List<Actor> buscarFechas(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaInicio,
			@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaFin) {
		return services.buscarActorFecha(fechaInicio, fechaFin);
	}

}
