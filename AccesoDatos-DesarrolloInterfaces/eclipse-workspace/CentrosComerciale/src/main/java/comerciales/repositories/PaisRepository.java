package comerciales.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comerciales.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String>{
	
	List<Pais> findByDescripcionStartingWith(String descripcion);

}
