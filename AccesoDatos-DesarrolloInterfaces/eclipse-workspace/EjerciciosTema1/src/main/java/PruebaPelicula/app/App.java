package PruebaPelicula.app;

import java.util.List;

import PruebaPelicula.dao.NoHayPeliculasException;
import PruebaPelicula.dao.Services;
import PruebaPelicula.modelo.Pelicula;

public class App {

	public static void main(String[] args) {
		
		Services connection = new Services();
		try {
			List<Pelicula> peliculas = connection.consultarPelicula(null);
			peliculas.forEach(System.out::println);
			
		} catch(NoHayPeliculasException e) {
			e.printStackTrace();
		}
		
		

	}

}
