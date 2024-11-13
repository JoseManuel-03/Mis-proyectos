package ejercicios.ejercicio02.modelo;

import lombok.Data;

@Data
public class Cliente {

	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private Boolean activo;
	
	
}
