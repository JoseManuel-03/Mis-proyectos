package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorNotFoundException;
import com.example.demo.service.ActorService;
import com.example.demo.service.ActorServiceException;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws ActorNotFoundException {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		ActorService service = context.getBean(ActorService.class);

		System.out.println(service.consultarActor(8L));

		/*
		 * Actor a1 = service.consultarActor(190L); 
		 * a1.setLastName("Blas");
		 * service.actualizarActor(a1);
		 */

		// service.borrarActor(201L);

		/*
		 * Actor a2 = new Actor(); 
		 * a2.setFirstName("Blasbbbdokdbfskjbskjbclj`lmpñmp`mnlrfpoiehnprewpfnpfoeinpiknfwpoioelhewiubwofubweoewbfowiebfiopewbfoweibof"); 
		 * a2.setLastName("de los Montes2");
		 * 
		 * List<Actor> lista = new ArrayList<Actor>(); 
		 * lista.add(a1); lista.add(a2);
		 * 
		 * try { service.crearActores(lista); } catch (ActorServiceException e) {
		 * System.out.println("Error en el insertado"); }
		 */

	}

}
