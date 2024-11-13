package ejercicios.ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio01.modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException {
		ResultSet rs = null;
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		try (Statement stmt = conn.createStatement()) {
			rs = stmt.executeQuery("select * from film");
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setNombre(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				resultado.add(p);
			}
		}
		return resultado;
	}

}
