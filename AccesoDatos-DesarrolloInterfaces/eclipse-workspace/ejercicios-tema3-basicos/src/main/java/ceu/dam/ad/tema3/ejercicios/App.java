package ceu.dam.ad.tema3.ejercicios;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasService;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.test.TestEj1;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.test.TestEj2;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.test.TestEj3;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.test.TestEj4;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.test.TestEj5;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//		TestEj1 ej1 = context.getBean(TestEj1.class);
//		ej1.test();
//		TestEj2 ej2 = context.getBean(TestEj2.class);
//		ej2.test();
//		TestEj3 ej3 = context.getBean(TestEj3.class);
//		ej3.test();
		TestEj4 ej4 = context.getBean(TestEj4.class);
		ej4.test();
//		TestEj5 ej5 = context.getBean(TestEj5.class);
//		ej5.test();
	}

}
