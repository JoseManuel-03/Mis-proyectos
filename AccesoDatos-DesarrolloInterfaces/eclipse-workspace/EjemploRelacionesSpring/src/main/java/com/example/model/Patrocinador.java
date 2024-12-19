package com.example.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Patrocinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPatrocinador;
	private String marcaComercial;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "equipo_patrocinador", joinColumns = {
			@JoinColumn(name = "id_patrocinador") }, inverseJoinColumns = { @JoinColumn(name = "id_equipo") })
	private List<Equipo> equipos;

}
