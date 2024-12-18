package com.example;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Equipo;
import com.example.model.Estadio;
import com.example.model.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		EquipoRepository repoEq = context.getBean(EquipoRepository.class);
		/*
		 * JugadorRepository repoJu = context.getBean(JugadorRepository.class);
		 * 
		 * Jugador jugador = repoJu.findById(2).get();
		 * 
		 * System.out.println(jugador);
		 */

		/*
		 * Estadio estadio = new Estadio(); estadio.setCiudad("Carmona");
		 * estadio.setCapacidad(9897); Equipo equipo = new Equipo();
		 * equipo.setNombre("Carmona FC"); equipo.setEstadio(estadio);
		 * 
		 * repo.save(equipo);
		 */
		Optional<Equipo> equipoOpt = repoEq.findById(2);
		System.out.println(equipoOpt.get());
	}

}
