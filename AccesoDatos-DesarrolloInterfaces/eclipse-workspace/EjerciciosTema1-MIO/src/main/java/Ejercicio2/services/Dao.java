package Ejercicio2.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio2.modelo.Cliente;

public class Dao {
	
	public List<Cliente> buscar(Connection conn) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "select * from customer";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("customer_id"));
				cliente.setFirstName(rs.getString("first_name"));
				cliente.setLastName(rs.getString("last_name"));
				cliente.setEmail(rs.getString("email"));
				cliente.setActivo(rs.getBoolean("active"));
				
				lista.add(cliente);
			
		}
			return lista;
		}
	}


}
