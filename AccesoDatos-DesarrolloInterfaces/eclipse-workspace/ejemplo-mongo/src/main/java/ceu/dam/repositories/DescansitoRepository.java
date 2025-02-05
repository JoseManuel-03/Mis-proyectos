package ceu.dam.repositories;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.model.Descansito;
@Repository
public interface DescansitoRepository extends MongoRepository<Descansito, String>, CustomDescansoRepository{
	
	public List<Descansito> findByProfesor(String profesor);
}
