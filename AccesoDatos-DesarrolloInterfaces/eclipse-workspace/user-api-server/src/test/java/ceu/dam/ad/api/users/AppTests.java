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
@ActiveProfiles("test") //mismo nombre que el archivo application-test.propperties; el test*, no que esta despues del guión
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppTests {

	@Autowired
	private UserService service;
	
	private User user;
	
	@BeforeEach
	void initTest() {
		user = new User();
		user.setUsername("elpepeTEST");
		user.setPassword("test");
		user.setEmail("test");
		
	}

	@Test
	@Order(1)
	void testCrearUsuario() throws DuplicateUserException, UserException{
		
			User userCreado = service.createUser(user);
			assertNotNull(userCreado);
			assertEquals(1L, userCreado.getId());
			
	}
	
	/*@Test
	@Order(2)
	void testconsultarUsuario() throws Exception {
		User userConsultado = service.getUser(1L);
		assertEquals(user.getEmail(), userConsultado.getEmail());
	}
	
	@Test
	@Order(3)
	void testconsultarUsuarioNoExiste() throws Exception {
		assertThrows(UserNotFoundException.class, null)
		assertEquals(user.getEmail(), userConsultado.getEmail());
	}*/
							
}
