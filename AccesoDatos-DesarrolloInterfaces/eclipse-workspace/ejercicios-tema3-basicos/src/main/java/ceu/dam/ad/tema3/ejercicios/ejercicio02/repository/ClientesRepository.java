package ceu.dam.ad.tema3.ejercicios.ejercicio02.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	


}
