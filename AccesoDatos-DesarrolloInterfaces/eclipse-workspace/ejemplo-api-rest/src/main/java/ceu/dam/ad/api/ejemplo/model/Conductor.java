package ceu.dam.ad.api.ejemplo.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Conductor {
	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Schema(description = "Identificador autogenerado del conductor. No es obligatorio en peticiones POST")
	private UUID uuidConductor;
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 6)
	private String nombre;
	@NotNull(message = "La edad es obligatoria")
	@Min(value = 18, message = "La edad tiene que ser mayor o igual a 18 años")
	private Integer edad;
}
