package ejercicios.ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio03.modelo.Pago;

public class PagosDao {

	public List<Pago> consultarPagos(Connection conn, Integer idCliente) throws SQLException{
		ResultSet rs = null;
		try (Statement stmt = conn.createStatement()){
			List<Pago> resultado = new ArrayList<Pago>();
			String sql = "select * from payment where customer_id = " + idCliente;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setFecha(rs.getDate("payment_date").toLocalDate());
				pago.setImporte(rs.getBigDecimal("amount"));
				resultado.add(pago);
			}
			return resultado;
		}
	}

}
