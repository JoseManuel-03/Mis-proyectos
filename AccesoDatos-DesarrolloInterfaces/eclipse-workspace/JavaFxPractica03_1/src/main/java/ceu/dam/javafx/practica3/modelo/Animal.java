package ceu.dam.javafx.practica3.modelo;

import ceu.dam.javafx.practica3.service.AnimalDataNotValidException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	private String tipo;
	private String nombre;
	private Integer edad;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * Valida si el atributo tipo del animal está correctamente relleno. En caso
	 * contrario, lanza AnimalDataNotValidException
	 * 
	 * @throws AnimalDataNotValidException
	 */
	public void validarTipo() throws AnimalDataNotValidException {
		if (tipo == null || tipo.trim().isEmpty()) {
			throw new AnimalDataNotValidException("El tipo no puede ser vacío");
		}
	}

	/**
	 * Valida si todos los atributos del animal están correctamente rellenos. En
	 * caso contrario, lanza AnimalDataNotValidException
	 * 
	 * @throws AnimalDataNotValidException
	 */
	public void validarTodo() throws AnimalDataNotValidException {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new AnimalDataNotValidException("El nombre no puede ser vacío");
		}
		if (edad == null || edad <= 0) {
			throw new AnimalDataNotValidException("La edad no puede ser vacía y tiene que ser mayor a 0");
		}
		validarTipo();
	}

}
