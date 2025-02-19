package ceu.dam.ad.api.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserNotFoundException;
import ceu.dam.ad.users.service.UserService;

@SpringBootTest
@ActiveProfiles("test") // mismo nombre que el archivo application-test.propperties; el test*, no que
						// esta despues del guión
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class AppTests {

	@Autowired
	private UserService service;

	private User user;

	@BeforeEach
	void initTest() {
		// Inicializa un nuevo usuario antes de cada test
		user = new User();
		user.setUsername("elpepeTEST");
		user.setPassword("test");
		user.setEmail("test");
	}

	@Test
	@Order(1)
	void testCrearUsuarioExitoso() throws DuplicateUserException, UserException {
		// Crear el usuario
		User userCreado = service.createUser(user);
		assertNotNull(userCreado); // Verifica que el usuario creado no sea null
		assertNotNull(userCreado.getId()); // Verifica que el ID no sea null, sin asumir el valor exacto
	}

	@Test
	@Order(2)
	void testConsultarUsuarioExistente() throws Exception {
		// Crear un usuario primero (esto depende de la implementación de tu servicio)
		User userCreado = service.createUser(user);
		// Consultar al usuario que acabamos de crear
		User userConsultado = service.getUser(userCreado.getId());
		assertEquals(user.getEmail(), userConsultado.getEmail()); // Verifica que el email coincida
	}

	@Test
	@Order(3)
	void testConsultarUsuarioNoExistente() throws Exception {
		// Asegurarse de que lanzarás la excepción cuando el usuario no existe
		assertThrows(UserNotFoundException.class, () -> service.getUser(999L)); // ID que no existe
	}
	@Test
	@Order(4)
	void testCrearUsuarioConEmailInvalido() {
	    user.setEmail("emailinvalido"); // Email con formato incorrecto
	    assertThrows(UserException.class, () -> service.createUser(user));  // Debe lanzar una excepción
	}

	@Test
	@Order(5)
	void testCrearUsuarioConCamposVacios() {
	    user.setUsername("");  // Nombre de usuario vacío
	    assertThrows(UserException.class, () -> service.createUser(user));  // Debe lanzar una excepción
	}
	@Test
	@Order(6)
	void testEliminarUsuario() throws Exception {
	    User userCreado = service.createUser(user);  // Primero crea el usuario
	    service.deleteUser(userCreado.getId());  // Luego lo elimina
	    assertThrows(UserNotFoundException.class, () -> service.getUser(userCreado.getId()));  // Debería lanzar excepción al intentar consultarlo
	}
	
	@Test
	@Order(7)
	void testActualizarUsuario() throws Exception {
	    User userCreado = service.createUser(user);  // Primero crea el usuario
	    userCreado.setUsername("nuevoNombre");  // Cambia el nombre de usuario
	    User userActualizado = service.updateUser(userCreado);  // Llama al método de actualización
	    assertEquals("nuevoNombre", userActualizado.getUsername());  // Verifica que el nombre se haya actualizado
	}



}
