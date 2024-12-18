package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	
	public List<Actor> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
