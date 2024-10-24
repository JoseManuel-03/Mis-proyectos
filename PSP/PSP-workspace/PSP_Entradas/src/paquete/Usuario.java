package paquete;

public class Usuario implements Runnable {

	private SistemaReserva sistemaReserva;
	private String nombreUsuario;
	private String nombreEvento;
	private int cantidadEntradas;

	public Usuario(SistemaReserva sistemaReserva, String nombreUsuario, String nombreEvento, int cantidadEntradas) {
		this.sistemaReserva = sistemaReserva;
		this.nombreUsuario = nombreUsuario;
		this.nombreEvento = nombreEvento;
		this.cantidadEntradas = cantidadEntradas;
	}

	@Override
	public void run() {
		boolean exito = sistemaReserva.reservar(nombreEvento, cantidadEntradas);
		if (exito) {
			System.out.println(
					nombreUsuario + " reservó " + cantidadEntradas + " entradas para el evento " + nombreEvento);
		} else {
			System.out.println(nombreUsuario + " no pudo reservar " + cantidadEntradas + " entradas para el evento "
					+ nombreEvento + " (No hay suficientes entradas disponibles).");
		}
	}
}
