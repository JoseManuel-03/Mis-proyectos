package ceu.dam.ad.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserNotFoundException;
import ceu.dam.ad.users.service.UserServiceImpl;
import ceu.dam.ad.users.service.UserUnauthorizedException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
@RestController
public class UserApiService {

	@Autowired
	private UserServiceImpl service;

	@GetMapping("/usuario/{id}")
	@Operation(summary = "Consulta de usuarios", description = "Consultar un usuario a partir de un ID")
	public User consultarUsuario(@PathVariable Long id) throws UserNotFoundException, UserException {
		return service.getUser(id);

	}

	@GetMapping("/usuario")
	@Operation(summary = "Consulta de usuarios", description = "Consultar un usuario a partir de un login y password")
	public User loginUsuario(@RequestParam String login, @RequestParam String password)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		return service.login(login, password);

	}

	@PostMapping("/usuario")
	@Operation(summary = "Crear usuario", description = "Crear un usuario")
	public User crearUsuario(@Valid @RequestBody User user) throws DuplicateUserException, UserException {
		return service.createUser(user);

	}

	@PutMapping("/usuario")
	@Operation(summary = "Cambiar contraseña de usuarios", description = "Cambiar contraseña un usuario a partir de un Id y una password antigua y otra nueva")
	public void cambiarContraseña(@RequestParam Long idUser, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws UserNotFoundException, UserUnauthorizedException, UserException {
		service.changePassword(idUser, oldPassword, newPassword);

	}

}
