		package actores.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import actores.modelo.Actor;

@Repository

public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	public List<Actor> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);


	public List<Actor> findByLastUpdateBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
