package ceu.dam.ad.tema3.ejercicios.ejercicio06.modelo;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name="PedidoLineaEj6")
@Table(name = "pedidosLineasNorm")
public class PedidoLinea {

	@Id
	private Long idLinea;
	@Column(name = "numeroLinea")
	private Integer numLinea;
	private String articulo;
	private BigDecimal precio;

}
