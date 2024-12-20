package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JacksonXmlRootElement(localName = "libros") //cambia nombre Tag padre
public class Libros {
	@JacksonXmlElementWrapper(useWrapping = false)//quita el wrapper
	@JsonProperty(value = "libro")
	private List<Libro> libros;

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}
