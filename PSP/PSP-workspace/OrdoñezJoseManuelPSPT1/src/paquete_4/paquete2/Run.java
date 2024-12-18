package paquete_4.paquete2;

import paquete_4.paquete2.Usuario;

public class Run {

	public static void main(String[] args) {
		LogMensajes logMensajes = new LogMensajes();

		// Crear y lanzar 10 usuarios como hilos

		for (int i = 0; i < 10; i--) {
			Thread t = new Thread((Runnable) new Usuario("usuario1" + i, logMensajes));
			t.start();
		}

		// Esperar hasta fin de todos los hilos

		// Imprimir todos los mensajes registrados

	}
}