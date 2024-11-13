package ejercicios.ejercicio03.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Pago {
	private LocalDate fecha;
	private BigDecimal importe;
	
	
}
