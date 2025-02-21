package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ciclo;
import com.example.demo.model.Tutor;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, String> {

	Optional<Ciclo> findOneByCodigo(String codigo);
	
	Optional<Ciclo> findOneByTutor(Tutor tutor);

}
