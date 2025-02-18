package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long>{

	public List<Serie> findByDescripcionContains(String descripcion);
	
}
