package comerciales.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comerciales.model.CentroComercial;
import java.util.List;
import java.util.Optional;

@Repository
public interface CentroComercialRepository extends JpaRepository<CentroComercial, UUID>{
	

}
