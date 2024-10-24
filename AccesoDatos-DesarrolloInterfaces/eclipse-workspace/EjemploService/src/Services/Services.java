package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Actor.Actor;
import dao.ActorDao;

public class Services extends Conexion{
	
	private ActorDao dao;
	
	public Services() {
		dao = new ActorDao();
		}

	public List<Actor> consultarActores(String filtro) throws NoHayActoresException {
		try (Connection conn = abrirConexion()){
			return  dao.buscar(conn, "%"+filtro+"%");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoHayActoresException("Error con excepciones", e);
		}
		
	}

} 
