package ceu.dam.ad.mongo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
public class Articulo {
	
	@Id
	private String codigo;
	private String descripcion;
	private BigDecimal precio;
	
}
	
