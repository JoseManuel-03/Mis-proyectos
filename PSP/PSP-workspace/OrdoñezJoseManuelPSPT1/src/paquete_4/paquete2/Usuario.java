package paquete_4.paquete2;

import java.util.Random;

public class Usuario {

	private String nombre;
	// Para enlazar el log de mensajes a usar
	private LogMensajes logMensajes;
	// Para gestionar el próximo ID de mensajes de usuario
	private static Long nextIdMensaje = 0L;

	public Usuario(String nombre, LogMensajes logMensajes) {
		this.nombre = nombre;
		this.logMensajes = logMensajes;
	}

	public void enviarMensajes() {
		// Ciclo continuo para enviar 100 mensajes con esperas aleatorias
		for (int i = 0; i < 100; i++) {
			enviarMensaje();
			pausar();
		}
	}

	public void enviarMensaje() {
		// Registra un nuevo ID de mansaje en la lista de mensajes en logMensajes
		logMensajes.registrarMensaje(nextIdMensaje);

	}

	public void pausar() {
		Random random = new Random();
		try {
			Thread.sleep(200 * (random.nextInt(199) + 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
