package ceu.dam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.model.Descansito;
import ceu.dam.repositories.DescansitoRepository;
@Service
public class DescansitoServices {
	
	@Autowired
	private DescansitoRepository descansito;
	
	public Descansito crearDescanso(Descansito descanso) {
		return descansito.save(descanso);
	}
	
	public List<Descansito> bucarProfesor(String profesor){
		return descansito.findByProfesor(profesor);
	}
	public List<Descansito> bucarPorNumAlumnos(Integer minimo){
		return descansito.buscarPorNumAlumnos(minimo);
	}
	public List<Descansito> bucarPorEdadAlumnos(Integer edad){
		return descansito.buscarPorEdadAlumnos(edad);
	}
	

}
