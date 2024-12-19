package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipo;
	private String nombre;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_estadio", nullable = false)
	private Estadio estadio;

	@OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
	private List<Jugador> jugadores;

/*	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "equipo_patrocinador", joinColumns = { @JoinColumn(name = "id_equipo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_patrocinador") })
	private List<Patrocinador> patrocinador;*/
}
