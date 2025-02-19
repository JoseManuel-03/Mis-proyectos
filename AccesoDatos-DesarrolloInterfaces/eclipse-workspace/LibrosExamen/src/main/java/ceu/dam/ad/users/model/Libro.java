package ceu.dam.ad.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	@Id
	private String isbn;
	private String titulo;
	@Column(name = "edicion")
	private Integer añoEdicion;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAñoEdicion() {
		return añoEdicion;
	}

	public void setAñoEdicion(Integer añoEdicion) {
		this.añoEdicion = añoEdicion;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", añoEdicion=" + añoEdicion + "]";
	}

}
