package ejercicios.ejercicio01.modelo;

import lombok.Data;

@Data
public class Pelicula {

	private Integer id;
	private String nombre;
	private Integer longitud;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	
	
	

}
