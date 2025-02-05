package ceu.dam.ad.mongo.model;

import lombok.Data;

@Data
public class PedidoDetalle {
	
	private Articulo articulo;
	private Integer cantidad;
	
}
