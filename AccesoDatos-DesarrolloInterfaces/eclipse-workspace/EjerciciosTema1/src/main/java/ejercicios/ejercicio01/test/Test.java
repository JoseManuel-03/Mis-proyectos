package ejercicios.ejercicio01.test;

import java.util.List;

import ejercicios.ejercicio01.modelo.Pelicula;
import ejercicios.ejercicio01.services.PeliculasException;
import ejercicios.ejercicio01.services.PeliculasService;

public class Test {
	
	public static void main(String[] args) {
		PeliculasService service = new PeliculasService();
		try {
			List<Pelicula> peliculas = service.consultarPeliculas();
			peliculas.forEach(System.out::println);
		} catch (PeliculasException e) {
			e.printStackTrace();
		}
	}

}
