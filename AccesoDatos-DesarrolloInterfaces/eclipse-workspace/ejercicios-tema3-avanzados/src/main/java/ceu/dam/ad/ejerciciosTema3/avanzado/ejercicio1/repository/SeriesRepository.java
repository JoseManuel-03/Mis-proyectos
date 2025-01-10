package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.model.Serie;

public interface SeriesRepository extends JpaRepository<Serie, Long> {

	List<Serie> findByDescripcionContaining(String descripcion);

}
