package ejemplos.ejemplo1.services;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Service {
	public void testConexion() {
		Connection conn = abrirConexion();
		System.out.println("Esta es mi conexión: " + conn);
		if (conn != null) {
			System.out.println("Todo OK!!");
		}
		else {
			System.out.println("Esto no rula...");
		}
	}
	
	
	protected Connection abrirConexion() {
		String urlConexion =  "jdbc:mariadb://10.50.16.101:3306/sakila";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila_alumnos";
		String password = "fuego";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
			return conn;
		}
		catch(Exception e) {
			System.err.println("No he podido abrir la conexión. " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("No puedo conectarme a la BBDD");
		}
		
	}
}
