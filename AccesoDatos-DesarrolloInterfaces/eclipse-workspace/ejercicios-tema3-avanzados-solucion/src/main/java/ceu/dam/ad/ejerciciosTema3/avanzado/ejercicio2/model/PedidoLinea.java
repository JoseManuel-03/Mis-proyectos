package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
	
	@ManyToOne() // fetch = FetchType.EAGER -- Al ser ManyToOne ya es EAGER por defecto
	@JoinColumn(name = "id_articulo")
	private Articulo articulo;

	@Override
	public String toString() {
		return "PedidoLinea [uidLinea=" + uidLinea + ", numLinea=" + numLinea + ", cantidad=" + cantidad + ", articulo="
				+ articulo + "]";
	}

	

	
}
