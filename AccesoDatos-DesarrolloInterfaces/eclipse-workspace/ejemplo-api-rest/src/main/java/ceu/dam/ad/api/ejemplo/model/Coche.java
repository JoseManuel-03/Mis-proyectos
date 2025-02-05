package ceu.dam.ad.api.ejemplo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id autogenerado del coche. No se debe indicar en POST", type = "Long")
	private Long id;
	@NotBlank(message = "La marca es obligatoria")
	private String marca;
	@NotBlank(message = "El modelo es obligatorio")
	private String modelo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_coche", nullable = false)
	@Size(min = 1, message = "El obligatorio al menos un conductor por coche")
	@Valid
	private List<Conductor> conductores;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(new ArrayList<Conductor>(conductores), new ArrayList<Conductor>(other.conductores))
				&& Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(conductores, id, marca, modelo);
	}

}
