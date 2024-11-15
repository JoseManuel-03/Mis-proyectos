package Ejercicio2.modelo;

import java.time.LocalDate;

import lombok.Data;

@Data

public class Pago {

	private Integer importe;
	private LocalDate fecha;

	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
