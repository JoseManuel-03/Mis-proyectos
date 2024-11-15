package Ejercicio4.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Pedido {

	private Integer idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	private List<LineaPedido> lista;

	public Pedido(Integer idPedido, LocalDate fechaPedido, LocalDate fechaEntrega, String cliente,
			List<LineaPedido> lista) {
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.cliente = cliente;
		lista = new ArrayList<LineaPedido>();
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<LineaPedido> getLista() {
		return lista;
	}

	public void setLista(List<LineaPedido> lista) {
		this.lista = lista;
	}

}
