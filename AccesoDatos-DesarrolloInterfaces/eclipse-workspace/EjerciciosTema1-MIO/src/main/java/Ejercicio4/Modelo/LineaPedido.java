package Ejercicio4.Modelo;

import java.math.BigDecimal;

import lombok.Data;

@Data

public class LineaPedido {

	private Long idPedido;
	private Integer numeroLinea;
	private String artículo;
	private BigDecimal precio;

}
