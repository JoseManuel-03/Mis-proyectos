package actores.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actores.modelo.Actor;
import actores.repository.ActorRepository;
import jakarta.transaction.Transactional;

@Service
public class ActorImpl {
	@Autowired
	private ActorRepository actorRepository;

	public Actor consultarActor(Long id) throws ActorNotFound {

		Optional<Actor> actorOpt = actorRepository.findById(id);
		if (!actorOpt.isPresent()) {
			throw new ActorNotFound("Actor no encontrado");
		}

		return actorOpt.get();

	}

	@Transactional

	public Actor crearActor(Actor actor) {
		return actorRepository.save(actor);

	}

	@Transactional

	public Actor actualizarActor(Actor actor) throws ActorNotFound {
		consultarActor(actor.getActorId());
		return actorRepository.save(actor);

	}

	@Transactional

	public void borrarActor(Long id) throws ActorNotFound {
		consultarActor(id);
		actorRepository.deleteById(id);

	}

	public List<Actor> buscarActorNombreApellidos(String firstName, String lastName) {
		return actorRepository.findByFirst_nameContainingOrLast_nameContaining(firstName, lastName);
	}

	public List<Actor> buscarActorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		return actorRepository.findByLast_updateBetween(fechaInicio, fechaFin);

	}

}
