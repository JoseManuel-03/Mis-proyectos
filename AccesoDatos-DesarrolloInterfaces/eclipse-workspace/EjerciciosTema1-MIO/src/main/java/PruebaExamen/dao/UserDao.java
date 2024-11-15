package PruebaExamen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import PruebaExamen.modelo.User;

public class UserDao {

	public Long insertUser(Connection conn, User usuario) throws SQLException {
		String sql = "insert into usuarios(username, password, email, fecha_alta, fecha_ult_login) values (?,?,?,?,?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getPassword());
			stmt.setString(3, usuario.getEmail());
			stmt.setDate(4, Date.valueOf(usuario.getCreatedDate()));
			stmt.setDate(5, Date.valueOf(usuario.getLastLoginDate()));
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		}
	}

	public User getByEmail(Connection conn, String email) throws SQLException {
		String sql = "select * from usuarios where email = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			return getUser(stmt);
		}

	}

	public User getById(Connection conn, Long id) throws SQLException {
		String sql = "select * from usuarios where id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, id);
			return getUser(stmt);
		}

	}

	public User getByUserName(Connection conn, String username) throws SQLException {
		String sql = "select * from usuarios where username = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			return getUser(stmt);
		}

	}

	public Integer updateUser(Connection conn, User usuario) throws SQLException {
		String sql = "update usuarios set username = ?, password = ?, email = ?, fecha_alta = ?, fecha_ult_login = ? where id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getPassword());
			stmt.setString(3, usuario.getEmail());
			stmt.setDate(4, Date.valueOf(usuario.getCreatedDate()));
			stmt.setDate(5, Date.valueOf(usuario.getLastLoginDate()));
			stmt.setLong(6, usuario.getId());
			return stmt.executeUpdate();
		}

	}

	private User getUser(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			User usuario = new User();
			usuario.setId(rs.getLong("id"));
			usuario.setUsername(rs.getString("username"));
			usuario.setPassword(rs.getString("password"));
			usuario.setEmail(rs.getString("email"));
			usuario.setCreatedDate(rs.getDate("fecha_alta").toLocalDate());
			usuario.setLastLoginDate(rs.getDate("fecha_ult_login").toLocalDate());
			return usuario;
		}
		return null;
	}

	public void deleteUser(Connection conn, Long id) throws SQLException {
		String sql = "delete from usuarios where id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
	}

}
