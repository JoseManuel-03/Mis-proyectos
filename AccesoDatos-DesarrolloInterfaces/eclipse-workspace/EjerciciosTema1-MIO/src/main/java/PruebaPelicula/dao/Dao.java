package PruebaPelicula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PruebaPelicula.modelo.Pelicula;

public class Dao {
	
	public List<Pelicula> buscar(Connection conn) throws SQLException {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		String sql = "select * from film";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setId(rs.getInt("film_id"));
				pelicula.setTitulo(rs.getString("title"));
				pelicula.setLongitud(rs.getInt("length"));
				lista.add(pelicula);
			
		}
			return lista;
		}
	}

}
