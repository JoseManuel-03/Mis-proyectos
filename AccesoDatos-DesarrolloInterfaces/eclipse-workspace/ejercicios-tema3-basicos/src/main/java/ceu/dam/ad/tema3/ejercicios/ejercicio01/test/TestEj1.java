package ceu.dam.ad.tema3.ejercicios.ejercicio01.test;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasException;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasService;

@Component
public class TestEj1 {
	@Autowired
	private PeliculasService service;

	public void test() {
		try {
			List<Pelicula> peliculas = service.consultarPeliculas(100);
			System.out.println(peliculas);
		} catch (PeliculasException e) {
			e.printStackTrace();
		}
	}

}
