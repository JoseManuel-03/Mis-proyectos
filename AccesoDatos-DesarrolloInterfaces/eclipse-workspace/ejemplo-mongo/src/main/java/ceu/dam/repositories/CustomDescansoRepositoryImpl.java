package ceu.dam.repositories;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ceu.dam.model.Descansito;
public class CustomDescansoRepositoryImpl implements CustomDescansoRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Descansito> buscarPorNumAlumnos(Integer minNumAlumnos) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("alumnos").gt(minNumAlumnos));
		
		return mongoTemplate.find(query, Descansito.class);
	}

	@Override
	public List<Descansito> buscarPorEdadAlumnos(Integer edad) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("alumnos.edad").is(edad));
		
		return mongoTemplate.find(query, Descansito.class);
	}
	
	

}
