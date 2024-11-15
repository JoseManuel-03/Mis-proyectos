package Ejercicio4.Modelo;

import java.math.BigDecimal;

import lombok.Data;

@Data

public class LineaPedido {

	private Long idPedido;
	private Integer numeroLinea;
	private String artículo;
	private BigDecimal precio;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public String getArtículo() {
		return artículo;
	}

	public void setArtículo(String artículo) {
		this.artículo = artículo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
