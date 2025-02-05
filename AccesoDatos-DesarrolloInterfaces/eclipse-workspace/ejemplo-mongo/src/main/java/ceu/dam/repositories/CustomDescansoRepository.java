package ceu.dam.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import ceu.dam.model.Descansito;
public interface CustomDescansoRepository {
	
	public List<Descansito> buscarPorNumAlumnos(Integer minNumAlumnos);
	
	public List<Descansito> buscarPorEdadAlumnos(Integer edad);

}
