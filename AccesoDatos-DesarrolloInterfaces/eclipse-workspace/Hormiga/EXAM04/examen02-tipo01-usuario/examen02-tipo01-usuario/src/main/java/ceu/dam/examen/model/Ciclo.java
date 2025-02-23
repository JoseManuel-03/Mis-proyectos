package ceu.dam.examen.model;

import java.util.List;

public class Ciclo {
	
	private String codigo; // no puede ser blanco
	private String descripcion;  // no puede ser blanco
	private Tutor tutor;  // no puede ser null
	private List<Asignatura> asignaturas; // no puede ser null y debe de tener al menos 1 asignatura
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	

	
	
}
