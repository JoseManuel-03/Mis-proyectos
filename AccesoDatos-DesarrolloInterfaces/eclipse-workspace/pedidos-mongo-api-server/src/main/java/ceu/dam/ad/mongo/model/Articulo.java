package ceu.dam.ad.mongo.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class Articulo {

	@NotBlank
	@NotNull
	private String codigo;
	@NotBlank
	@NotNull
	private String descripcion;
	@NotBlank
	@NotNull
	private BigDecimal precio;

}
