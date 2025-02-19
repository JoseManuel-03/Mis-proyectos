package ceu.dam.ad.users.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "autores")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Long id;
	private String nombre;
	@Column(name = "año_nacimiento")
	private Integer añoNacimiento;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_autor", nullable = false)
	private List<Libro> obra;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_pais")
	private Pais origen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAñoNacimiento() {
		return añoNacimiento;
	}

	public void setAñoNacimiento(Integer añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
	}

	public List<Libro> getObra() {
		return obra;
	}

	public void setObra(List<Libro> obra) {
		this.obra = obra;
	}

	public Pais getOrigen() {
		return origen;
	}

	public void setOrigen(Pais origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", añoNacimiento=" + añoNacimiento + ", obra=" + obra
				+ ", origen=" + origen + "]";
	}

}
