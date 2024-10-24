package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Actor.Actor;
import Services.NoHayActoresException;

public class ActorDao {
	
	public List<Actor> buscar(Connection conn,String filtro) throws NoHayActoresException, SQLException{
		List<Actor> lista = new ArrayList<>();
		String sql = "select * from actor where first_name like ? or last_name like ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, filtro);
			stmt.setString(2, filtro);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("actor_id"));
				actor.setNombre(rs.getString("first_name"));
				actor.setApellido(rs.getString("last_name"));
				lista.add(actor);
			
		}
		return lista;
	}

	}
}
