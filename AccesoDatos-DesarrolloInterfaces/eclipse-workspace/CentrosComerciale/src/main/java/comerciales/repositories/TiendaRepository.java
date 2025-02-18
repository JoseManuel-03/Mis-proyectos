package comerciales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comerciales.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long>{

}
