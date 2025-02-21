package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	Optional<Alumno> findOneByDni(String dni);


	//List<Alumno> findByCodigoBetween(String codigo, LocalDate fechaInicio, LocalDate fechaFin);

}
