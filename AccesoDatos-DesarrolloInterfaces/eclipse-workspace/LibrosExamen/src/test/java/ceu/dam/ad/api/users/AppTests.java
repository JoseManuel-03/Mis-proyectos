package ceu.dam.ad.api.users;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ceu.dam.ad.users.model.Autor;
import ceu.dam.ad.users.service.AutorNotFoundException;
import ceu.dam.ad.users.service.AutorServiceException;
import ceu.dam.ad.users.service.AutoresService;

@SpringBootTest
@ActiveProfiles("test") // mismo nombre que el archivo application-test.propperties; el test*, no que
						// esta despues del guión
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppTests {

	@Autowired
	private AutoresService autoresService;

	private Autor autor;

	@Test
	@Order(1)
	void testGuardarAutoresConNombreValido() throws AutorServiceException, AutorNotFoundException {
		List<Autor> autores = new ArrayList<>();
		Autor autor = new Autor();
		autor.setNombre("Autor de prueba");
		autor.setAñoNacimiento(1990);
		// Agregar más propiedades si es necesario

		autores.add(autor);

		// Llamamos al método y verificamos que se guarda correctamente
		autoresService.guardarAutores(autores);

		// Verificamos que se guardó el autor correctamente en la base de datos
		assertNotNull(autoresService.consultarAutor(autor.getId()));
	}

	@Test
	@Order(2)
	void testGuardarAutoresConNombreNulo() {
		List<Autor> autores = new ArrayList<>();
		Autor autor = new Autor();
		autor.setNombre(null); // El nombre es nulo, por lo que debe lanzar excepción
		autor.setAñoNacimiento(1990);

		autores.add(autor);

		// Llamamos al método y verificamos que lanza la excepción
		assertThrows(AutorServiceException.class, () -> autoresService.guardarAutores(autores));
	}

}
