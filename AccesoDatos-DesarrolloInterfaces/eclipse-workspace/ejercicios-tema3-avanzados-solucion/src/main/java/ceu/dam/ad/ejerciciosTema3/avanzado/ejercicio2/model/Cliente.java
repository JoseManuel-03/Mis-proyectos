package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	private String dni;
	
	private String nombre;
	
	private String apellidos;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private Set<Pedido> pedidos;
	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
