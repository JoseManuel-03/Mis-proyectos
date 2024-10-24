package PruebaPelicula.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import PruebaPelicula.modelo.Pelicula;

public class Services extends Conexion{
	
	private Dao dao;

	public Services() {
		dao = new Dao();
	}
	

	public List<Pelicula> consultarPelicula(Integer longitud) throws NoHayPeliculasException {
		try (Connection conn = abrirConexion()){
			return dao.buscar(conn).stream().filter(p ->p.getLongitud() < longitud).toList();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoHayPeliculasException("Error con excepciones", e);
		}
		
	}
	
	
	
}
