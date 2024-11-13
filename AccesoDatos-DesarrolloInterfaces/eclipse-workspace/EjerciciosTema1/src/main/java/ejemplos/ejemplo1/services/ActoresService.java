package ejemplos.ejemplo1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejemplos.ejemplo1.dao.ActoresDao;
import ejemplos.ejemplo1.modelo.Actor;

public class ActoresService extends Service{

	private ActoresDao dao;
	
	public ActoresService() {
		dao = new ActoresDao();
	}
	
	public List<Actor> buscarActores(String filtro) throws ActorServiceException{
		
		try(Connection conn = abrirConexion()){
			return dao.buscar(conn, "%"+filtro+"%");
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new ActorServiceException("Error consultando excepciones", e);
		}
		
	}
	
}




