package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;

@Service

public class ActorService {

	@Autowired
	private ActorRepository repository;

	public Actor consultarActor(Long id) throws ActorNotFoundException {
		Optional<Actor> actor = repository.findById(id);
		
	//return actor.orElseThrow(()-> new ActorNotFoundException("No existe con ese id");
		
		if(!actor.isPresent()) {
			throw new ActorNotFoundException("No existe actor con ese id");
		}
		return actor.get();
	}

	// Consulta todos los actores que contienen en su nombre o apellidos el filtro
	// indicado
	public List<Actor> consultarActores(String filtro) {
		return repository.findByFirstNameContainingOrLastNameContaining(filtro, filtro);

	}

	public void crearActor(Actor actor) throws ActorServiceException {

		try {
			repository.save(actor);
		} catch (DataAccessException e) {
			throw new ActorServiceException();
		}
	}

	public void crearActores(List<Actor> actores) throws ActorServiceException {

		try {

			repository.saveAll(actores);
			// actores.forEach(a -> repository.save(a));
			/*
			 * for (Actor actor : actores) { 
			 * repository.save(actor); }
			 */
		} catch (DataAccessException e) {
			throw new ActorServiceException();
		}
	}
	
	public void actualizarActor(Actor actor) {
		repository.save(actor);
	}
	
	public void borrarActor(Long id) {
		repository.deleteById(id);
	}

}
