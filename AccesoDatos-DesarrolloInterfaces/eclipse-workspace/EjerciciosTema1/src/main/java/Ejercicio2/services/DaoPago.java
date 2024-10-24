package Ejercicio2.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio2.modelo.Pago;

public class DaoPago {

	public List<Pago> buscar(Connection conn, Integer id) throws SQLException {
		List<Pago> lista = new ArrayList<Pago>();
		String sql = "SELECT * FROM payment p JOIN customer c ON c.customer_id = p.customer_id";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setImporte(rs.getInt("amount"));
				pago.setFecha(rs.getDate("payment_date").toLocalDate());
				lista.add(pago);

			}
			return lista;
		}
	}

}
