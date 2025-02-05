package ceu.dam;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.model.Alumno;
import ceu.dam.model.Descansito;
import ceu.dam.services.DescansitoServices;
import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		DescansitoServices services = context.getBean(DescansitoServices.class);

		Descansito d = new Descansito();
		d.setProfesor("Abel");
		d.setDuracion(20);
		d.setAutorizado(false);
		d.setAlumnos(new ArrayList<>());
		d.getAlumnos().add(new Alumno("Blas",22, true));
		d.getAlumnos().add(new Alumno("Bles",21, true));
		d.getAlumnos().add(new Alumno("Blis",23, false));
		
		//System.out.println(services.crearDescanso(d));
		
		//services.bucarProfesor("Abel").forEach(System.out::println);
		
		//services.bucarPorNumAlumnos(1).forEach(System.out::println);
		
		services.bucarPorEdadAlumnos(21).forEach(System.out::println);
		
	}

}
