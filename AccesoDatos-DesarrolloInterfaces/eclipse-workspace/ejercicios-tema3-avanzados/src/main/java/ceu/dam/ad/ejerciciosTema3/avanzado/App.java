package ceu.dam.ad.ejerciciosTema3.avanzado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.test.Test1;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.test.Test2;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.test.Test3;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//		Test1 ej1 = context.getBean(Test1.class);
//		ej1.test();
//		Test2 ej2 = context.getBean(Test2.class);
//		ej2.test();
		Test3 ej3 = context.getBean(Test3.class);
		ej3.test();
	}

}

