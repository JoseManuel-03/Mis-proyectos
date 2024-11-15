package ejercicios.ejercicio03.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Pago {
	private LocalDate fecha;
	private BigDecimal importe;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}
