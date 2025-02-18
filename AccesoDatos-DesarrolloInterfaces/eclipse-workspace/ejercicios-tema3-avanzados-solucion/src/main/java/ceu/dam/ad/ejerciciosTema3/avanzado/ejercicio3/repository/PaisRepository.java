package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Pais;
import java.util.List;


public interface PaisRepository extends JpaRepository<Pais, String>{

	public List<Pais> findByDescripcionStartingWith(String descripcion);
}
