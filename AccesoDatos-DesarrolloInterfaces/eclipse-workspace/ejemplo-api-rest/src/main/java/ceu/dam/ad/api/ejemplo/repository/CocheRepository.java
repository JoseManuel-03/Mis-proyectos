package ceu.dam.ad.api.ejemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.api.ejemplo.model.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long>{
	
	public List<Coche> findByMarcaContaining(String marca);
	
}
