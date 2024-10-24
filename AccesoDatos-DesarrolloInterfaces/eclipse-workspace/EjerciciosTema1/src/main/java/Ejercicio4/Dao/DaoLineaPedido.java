package Ejercicio4.Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Ejercicio4.Modelo.LineaPedido;
import Ejercicio4.Modelo.Pedido;

public class DaoLineaPedido extends Conexion {
	public void insertarLineaPedidos(Connection conn, LineaPedido lineapedido) throws SQLException {
		String sql = "INSERT INTO pedidos_lineas (id_pedido,numero_linea,articulo,precio) VALUES (?,?,?,?);";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setLong(1, lineapedido.getIdPedido());
			stmt.setInt(2, lineapedido.getNumeroLinea());
			stmt.setString(3, lineapedido.getArtículo());
			stmt.setBigDecimal(4, lineapedido.getPrecio());

			stmt.executeUpdate();
		}

	}

	public List<LineaPedido> consultarLineaPedidos(Connection conn, Long idPedido) throws SQLException {
		String sql = "SELECT * FROM pedidos_lineas WHERE id_pedido = " + idPedido;
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			List<LineaPedido> listaLineasPedido = new ArrayList<LineaPedido>();
			while (rs.next()) {
				LineaPedido lineaPedido = new LineaPedido();
				lineaPedido.setArtículo(rs.getString("articulo"));
				lineaPedido.setPrecio(rs.getBigDecimal("precio"));
				lineaPedido.setNumeroLinea(rs.getInt("numero_linea"));
				listaLineasPedido.add(lineaPedido);

			}
			return listaLineasPedido;

		}

	}
}