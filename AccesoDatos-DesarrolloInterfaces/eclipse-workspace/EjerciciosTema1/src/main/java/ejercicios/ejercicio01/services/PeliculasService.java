package ejercicios.ejercicio01.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio01.dao.PeliculasDao;
import ejercicios.ejercicio01.modelo.Pelicula;

public class PeliculasService extends Service{

	private PeliculasDao dao;
	
	public PeliculasService() {
		dao = new PeliculasDao();
	}
	
	
	public List<Pelicula> consultarPeliculas() throws PeliculasException {
		return consultarPeliculas(100);
	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasException {
		try (Connection conn = abrirConexionSakila()){
			return dao.consultarPeliculas(conn)
					.stream()
					.filter(p -> p.getLongitud() < longitud)
					.toList();
		} 
		catch (SQLException e) {
			System.err.println("Error al consultar peliculas");
			throw new PeliculasException("Error al consultar peliculas en BBDD", e);

		}

	}

}
