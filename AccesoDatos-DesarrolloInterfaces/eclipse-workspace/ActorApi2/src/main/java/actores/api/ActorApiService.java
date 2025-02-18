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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Authorization")
public class ActorApiService {

	@Autowired
	private ActorImpl actorImpl;

	@PostMapping("/usuario")
	public Actor crearActor(@Valid @RequestBody Actor actor) {
		return actorImpl.crearActor(actor);
	}

	@PutMapping("/usuario")
	public Actor actualizarActor(@Valid @RequestBody Actor actor) throws ActorNotFound {
		return actorImpl.actualizarActor(actor);

	}

	@DeleteMapping("/usuario/{id}")
	public void borrarActor(@PathVariable Long id) throws ActorNotFound {
		actorImpl.borrarActor(id);

	}

	@GetMapping("/usuario/{id}")
	public Actor consultarPorId(@PathVariable Long id) throws ActorNotFound {
		return actorImpl.consultarActor(id);

	}

	@GetMapping("/usuario/nombre")
	public List<Actor> consultarPorNombreApellido(@RequestParam String firstName, @RequestParam String lastName) {
		return actorImpl.buscarActorNombreApellidos(firstName, lastName);

	}

	@GetMapping("/usuario")
	public List<Actor> consultarFechas(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaInicio,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaFin) {
		return actorImpl.buscarActorFecha(fechaInicio, fechaFin);

	}

}
