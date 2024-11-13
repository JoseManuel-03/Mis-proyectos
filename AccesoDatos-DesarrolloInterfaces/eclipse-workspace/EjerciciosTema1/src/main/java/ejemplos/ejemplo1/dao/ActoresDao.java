package ejemplos.ejemplo1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejemplos.ejemplo1.modelo.Actor;

public class ActoresDao {

	
	public List<Actor> buscar(Connection conn, String filtro) throws SQLException{
		List<Actor> lista = new ArrayList<Actor>();
		String sql = "SELECT * FROM ACTOR WHERE FIRST_NAME LIKE ? OR LAST_NAME LIKE ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, filtro);
			stmt.setString(2, filtro);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Actor a = new Actor();
				a.setId(rs.getLong("actor_id"));
				a.setName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				lista.add(a);
			}
			return lista;
		}
		
		
	}
	
	
}
