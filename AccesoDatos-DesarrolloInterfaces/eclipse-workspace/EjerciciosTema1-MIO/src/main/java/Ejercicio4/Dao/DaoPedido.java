package Ejercicio4.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Ejercicio4.Modelo.Pedido;

public class DaoPedido extends Conexion {

	public Long insertarPedidos(Connection conn, Pedido pedido) throws SQLException {
		String sql = "INSERT INTO pedidos (fecha_pedido,fecha_entrega,cliente) VALUES (?,?,?);";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(3, pedido.getCliente());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next(); 												// PARA OBTENER EL ID
			return rs.getLong(1);
		}

	}

	public Pedido consultarPedidos(Connection conn, Long idPedido) throws SQLException {
		String sql = "SELECT * FROM pedidos WHERE id_pedido = " +idPedido;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			Pedido pedido = new Pedido();
			if (rs.next()) {
				Integer id = rs.getInt("id_pedido");
				LocalDate fechaPedido = rs.getDate("fecha_pedido").toLocalDate();
				LocalDate fechaEntrega = rs.getDate("fecha_entrega").toLocalDate();
				String cliente = rs.getString("cliente");

				pedido.setIdPedido(id);
				pedido.setFechaPedido(fechaPedido);
				pedido.setFechaEntrega(fechaEntrega);
				pedido.setCliente(cliente);

				return pedido;

			} else {
				return null;
			}

		}

	}
}
