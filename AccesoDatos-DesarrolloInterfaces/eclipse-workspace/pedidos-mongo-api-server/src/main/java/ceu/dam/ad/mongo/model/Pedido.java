package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document
public class Pedido {
	@Id
	private String id;
	@NotBlank
	@NotNull
	private Cliente cliente;
	@NotBlank
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fecha;
	@NotBlank
	@NotNull
	private Integer numero;
	@NotBlank
	@NotNull
	@Size(min = 1)
	private List<PedidoDetalle> detalles;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public List<PedidoDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<PedidoDetalle> detalles) {
		this.detalles = detalles;
	}
	
	

}
