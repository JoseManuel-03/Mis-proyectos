package ceu.dam.examen.model;

import java.time.LocalDate;

public class Alumno {

	private Long id;
	private String dni;
	private String nombreCompleto;
	private LocalDate fechaMatricula;
	private Ciclo ciclo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public Ciclo getCiclo() {
		return ciclo;
	}
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	
	
}
