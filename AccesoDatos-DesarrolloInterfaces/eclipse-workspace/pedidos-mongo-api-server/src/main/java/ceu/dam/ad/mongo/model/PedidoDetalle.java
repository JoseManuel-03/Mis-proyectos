package ceu.dam.ad.mongo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PedidoDetalle {
	@NotBlank
	@NotNull
	private Articulo articulo;
	@NotBlank
	@NotNull
	@Size(min = 1)
	private Integer cantidad;
	
}
