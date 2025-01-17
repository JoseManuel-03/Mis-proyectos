package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_lineas")
public class PedidoLinea {
	
	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Column(name = "uuid_linea_pedido")
	private UUID uidLinea;
	private Integer numLinea;
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name = "id_articulo")
	private Articulo articulo;

	public UUID getUidLinea() {
		return uidLinea;
	}

	public void setUidLinea(UUID uidLinea) {
		this.uidLinea = uidLinea;
	}

	public Integer getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(Integer numLinea) {
		this.numLinea = numLinea;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "PedidoLinea [uidLinea=" + uidLinea + ", numLinea=" + numLinea + ", cantidad=" + cantidad + ", articulo="
				+ articulo + "]";
	}

}
