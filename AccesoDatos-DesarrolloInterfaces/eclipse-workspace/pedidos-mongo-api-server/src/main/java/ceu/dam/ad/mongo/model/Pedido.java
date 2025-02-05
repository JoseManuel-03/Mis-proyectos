package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Pedido {
	@Id
	private String id;
	@NotBlank
	@NotNull
	private Cliente cliente;
	@NotBlank
	@NotNull
	private LocalDate fecha;
	@NotBlank
	@NotNull
	private Integer numero;
	@NotBlank
	@NotNull
	@Size(min = 1)
	private List<PedidoDetalle> detalles;

}
