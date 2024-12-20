package Ejercicio4.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Ejercicio4.Modelo.Usuario;

public class DaoUser {

	public Long insertUser(Connection conn, Usuario user) throws SQLException {
		String sql = "INSERT INTO USUARIOS (username,pass,email,fecha_alta,fecha_ult_login) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, Date.valueOf(user.getFechaAlta()));
			stmt.setDate(5, Date.valueOf(user.getFechaUltLogin()));

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();

			return rs.getLong(1);
		}

	}

	public Usuario getByEmail(Connection conn, String email) throws SQLException {

		String sql = "SELECT * FROM pedidos WHERE id_pedido = " + email;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			Usuario usuario = new Usuario();
			if (rs.next()) {
				Long idUser = rs.getLong("idUser");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String emailAd = rs.getString("email");
				LocalDate fechaAlta = rs.getDate("fechaAlta").toLocalDate();
				LocalDate fechaUltLogin = rs.getDate("fechaUltLogin").toLocalDate();

				usuario.setIdUser(idUser);
				usuario.setUsername(username);
				usuario.setPassword(password);
				usuario.setEmail(emailAd);
				usuario.setFechaAlta(fechaAlta);
				usuario.setFechaUltLogin(fechaUltLogin);

				return usuario;
			}
		}
		return null;

	}

	public Usuario getById(Connection conn, Long id) throws SQLException {

		String sql = "SELECT * FROM pedidos WHERE id_pedido = " + id;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			Usuario usuario = new Usuario();
			if (rs.next()) {
				Long idUser = rs.getLong("idUser");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String emailAd = rs.getString("email");
				LocalDate fechaAlta = rs.getDate("fechaAlta").toLocalDate();
				LocalDate fechaUltLogin = rs.getDate("fechaUltLogin").toLocalDate();

				usuario.setIdUser(idUser);
				usuario.setUsername(username);
				usuario.setPassword(password);
				usuario.setEmail(emailAd);
				usuario.setFechaAlta(fechaAlta);
				usuario.setFechaUltLogin(fechaUltLogin);

				return usuario;
			}
		}

		return null;

	}

	public Usuario getByUser(Connection conn, String username) throws SQLException {

		String sql = "SELECT * FROM pedidos WHERE id_pedido = " + username;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			Usuario usuario = new Usuario();
			if (rs.next()) {
				Long idUser = rs.getLong("idUser");
				String usernames = rs.getString("username");
				String password = rs.getString("password");
				String emailAd = rs.getString("email");
				LocalDate fechaAlta = rs.getDate("fechaAlta").toLocalDate();
				LocalDate fechaUltLogin = rs.getDate("fechaUltLogin").toLocalDate();

				usuario.setIdUser(idUser);
				usuario.setUsername(usernames);
				usuario.setPassword(password);
				usuario.setEmail(emailAd);
				usuario.setFechaAlta(fechaAlta);
				usuario.setFechaUltLogin(fechaUltLogin);

				return usuario;
			}
		}
		return null;

	}

	public void updateUser(Connection conn, Usuario user) throws SQLException {
		String sql = "UPDATE usuarios SET username = ?, pass = ?, email = ?, fecha_alta = ? ,fecha_ult_login = ? WHERE idUser = ? ";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, user.getIdUser());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setDate(5, Date.valueOf(user.getFechaAlta()));
			stmt.setDate(6, Date.valueOf(user.getFechaUltLogin()));

			stmt.executeUpdate();
		}

	}

}
