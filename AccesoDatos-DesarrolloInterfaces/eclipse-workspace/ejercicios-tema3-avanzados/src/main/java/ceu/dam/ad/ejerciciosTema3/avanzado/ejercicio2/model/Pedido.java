package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Column(name = "uuid_pedido")
	private UUID uidPedido;
	@ManyToOne
	@JoinColumn(name="dni_cliente", nullable=false)
	private Cliente cliente;
	private Date fecha;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "uuid_pedido", nullable=false)
	private List<PedidoLinea> lineas;

	public UUID getUidPedido() {
		return uidPedido;
	}

	public void setUidPedido(UUID uidPedido) {
		this.uidPedido = uidPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<PedidoLinea> getLineas() {
		return lineas;
	}

	public void setLineas(List<PedidoLinea> lineas) {
		this.lineas = lineas;
	}

	@Override
	public String toString() {
		return "Pedido [uidPedido=" + uidPedido + ", fecha=" + fecha + ", lineas=" + lineas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(uidPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(uidPedido, other.uidPedido);
	}

}
