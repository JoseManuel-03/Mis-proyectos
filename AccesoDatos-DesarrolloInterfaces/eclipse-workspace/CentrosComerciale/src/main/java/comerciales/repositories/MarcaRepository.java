package comerciales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comerciales.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, String>{

}
