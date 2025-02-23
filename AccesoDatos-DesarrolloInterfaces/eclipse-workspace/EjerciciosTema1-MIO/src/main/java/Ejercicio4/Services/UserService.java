package Ejercicio4.Services;

import java.sql.Connection;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ejercicio4.Dao.Conexion;
import Ejercicio4.Dao.DaoUser;
import Ejercicio4.Interfaz.Interface;
import Ejercicio4.Modelo.Usuario;

public class UserService extends Conexion implements Interface {

	private static final Logger log = LoggerFactory.getLogger(PedidosService.class);
	private DaoUser daoUser;

	@Override
	public void changePass(Long idUser, String password, String newPassword) throws ErrorCambiandoPasswordException {
		try (Connection conn = abrirConexion()) {
			log.debug("Cambiando la contraseña");
			Usuario user = daoUser.getById(conn, idUser);
			String passwordCifrada = DigestUtils.sha256Hex(password);
			if (user.getPassword().equals(passwordCifrada)) {
				throw new ErrorCambiandoPasswordException("Error al intentar cambiar la contraseña");
			}
			newPassword = DigestUtils.sha256Hex(password);
			user.setPassword(newPassword);
			daoUser.updateUser(conn, user);

		} catch (SQLException e) {
			log.error("Error cambiando contraseña", e);
			throw new ErrorCambiandoPasswordException("Error al intentar cambiar la contraseña", e);
		}

	}

	@Override
	public Usuario registrer(Usuario user) throws HayUsuariosException {
		try (Connection conn = abrirConexion()) {

			if (daoUser.getByUser(conn, user.getUsername()) == null) {

				log.error("Error usuario ya registrado");

			} else if (daoUser.getByEmail(conn, user.getEmail()) == null) {

				log.error("Error usuario ya registrado");

			} else {
				log.debug("Registrando usuario nuevo");
				Long id = daoUser.insertUser(conn, user);
				user.setIdUser(id);
			}

			return user;

		} catch (SQLException e) {
			log.error("Error registrando usuario", e);
			throw new HayUsuariosException("Ya hay un usuario igual registrado", e);
		}

	}

	@Override
	public Usuario login(String login, String password) throws NoHayUsuariosException {
		try (Connection conn = abrirConexion()) {
			log.debug("Logeando usuario");

			if (daoUser.getByUser(conn, login) == null) {
				Usuario user = daoUser.getByUser(conn, login);

				if (daoUser.getByUser(conn, login).getPassword().equals(password)) {
					return user;
				}

			} else if (daoUser.getByEmail(conn, login) == null) {
				Usuario user = daoUser.getByUser(conn, login);

				if (daoUser.getByUser(conn, login).getPassword().equals(password)) {
					return user;
				}

			} else {
				log.error("Error logeando usuario");
			}

			return null;

		} catch (SQLException e) {
			log.error("Error Logeando usuario", e);
			throw new NoHayUsuariosException("Ya hay un usuario igual registrado", e);
		}

	}

	@Override
	public Usuario consult(Long idUser) throws NoHayUsuariosException {
		try (Connection conn = abrirConexion()) {
			log.debug("Consultando usuario");

			Usuario user = daoUser.getById(conn, idUser);
			return user;

		} catch (SQLException e) {
			log.error("Error registrando pedido", e);
			throw new NoHayUsuariosException("Ya hay un usuario igual registrado", e);
		}

	}

}
