package ceu.dam.ad.tema3.ejercicios.ejercicio01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {

	public List<Pelicula> findByLongitudIsLessThan(Integer longitud);

}
