package ceu.dam.ad.api.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserService;

@SpringBootTest
@ActiveProfiles("test") //mismo nombre que el archivo application-test.propperties; el test*, no que esta despues del guión
class AppTests {

	@Autowired
	private UserService service;
	
	@Test
	void testCrearUsuario() throws DuplicateUserException, UserException{
		User user = new User();
		user.setUsername("elpepeTEST");
		user.setPassword("test");
		user.setEmail("test");
		
		
			User userCreado = service.createUser(user);
			assertNotNull(userCreado);
			assertEquals(1L, userCreado.getId());
			
	
	}
							
}
