package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJugador;
	private Integer dorsal;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;

	public String toString() {
		return idJugador + " - " + dorsal + " - " + nombre;

	}

}
