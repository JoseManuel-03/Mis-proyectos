package actores.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import actores.modelo.Actor;

@Repository

public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findByFirst_nameContainingOrLast_nameContaining(String firstName, String lastName);

	List<Actor> findByLast_updateBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
