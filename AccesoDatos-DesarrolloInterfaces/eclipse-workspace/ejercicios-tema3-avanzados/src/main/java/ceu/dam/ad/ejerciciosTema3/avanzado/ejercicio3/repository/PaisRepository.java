package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Pais;
@Repository
public interface PaisRepository extends JpaRepository<Pais, String>{
	
	List<Pais> findByDescripcionStartsWith(String descripcion);

}
