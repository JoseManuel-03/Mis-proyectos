package ceu.dam.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
	
	private String nombre;
	private Integer edad;
	private Boolean fumador;

}
