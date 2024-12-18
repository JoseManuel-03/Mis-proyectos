package paquete_4.paquete1;

import java.util.ArrayList;
import java.util.List;

public class LogMensajes {

	private List<Long> colaMensajes;

	public LogMensajes() {
		colaMensajes = new ArrayList<>();
	}

	public void registrarMensaje(Long idMensaje) {
		colaMensajes.add(idMensaje);
	}

	public void imprimirColaMensajes() {
		//
		System.out.println("Cola de mensajes enviados:");
		for (Long idMensaje : colaMensajes) {
			System.out.println("\tMensaje ID: " + idMensaje);
		}
	}
}
