package ceu.dam.javafx.examen.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reparacion {

	private String matricula;
	private LocalDate fecha;
	private String operario;
	private BigDecimal presupuesto;
	
	public Reparacion(String matricula, LocalDate fecha, String operario, BigDecimal presupuesto) {
		super();
		this.matricula = matricula;
		this.fecha = fecha;
		this.operario = operario;
		this.presupuesto = presupuesto;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getOperario() {
		return operario;
	}
	public void setOperario(String operario) {
		this.operario = operario;
	}
	public BigDecimal getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
}
