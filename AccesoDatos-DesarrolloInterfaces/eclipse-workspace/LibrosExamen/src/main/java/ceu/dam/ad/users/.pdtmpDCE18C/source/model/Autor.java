package ceu.dam.ad.tema3.examen.model;

import java.util.List;

public class Autor {

	private Long id;
	private String nombre;
	private Integer añoNacimiento;
	private List<Libro> obra;
	private Pais origen;
	
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", añoNacimiento=" + añoNacimiento + ", obra=" + obra
				+ ", origen=" + origen + "]";
	}

	
	
	
	
	
	
	
}
