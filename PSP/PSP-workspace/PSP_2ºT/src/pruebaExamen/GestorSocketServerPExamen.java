package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class GestorSocketServerPExamen implements Runnable {

	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public GestorSocketServerPExamen(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
			String mensaje;
			while ((mensaje = in.readLine()) != null) {

				System.out.println("Mensaje recibido: " + mensaje);
				String respuesta = procesarMensaje(mensaje);
				System.out.println("Respuesta enviada: " + respuesta);
				out.println(respuesta);
				if (respuesta.equals("#Finalizado#")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Conexión cerrada.");
		}
	}

	private String procesarMensaje(String mensaje) {

		if (mensaje.startsWith("#Listado números#")) {

			try {
				String[] partes = mensaje.split("#");

				int inicio = Integer.parseInt(partes[2]);
				int fin = Integer.parseInt(partes[3]);

				if (inicio <= fin) {
					StringBuilder resultado = new StringBuilder();

					for (int i = inicio; i <= fin; i++) {
						resultado.append(i).append("|");
					}
					return resultado.substring(0, resultado.length() - 1);
				}
			} catch (Exception e) {
				return "#Error#";
			}
		} else if (mensaje.startsWith("#Numero aleatorio#")) {

			try {
				String[] partes = mensaje.split("#");
				int inicio = Integer.parseInt(partes[2]);
				int fin = Integer.parseInt(partes[3]);

				if (inicio <= fin) {
					Random random = new Random();

					return String.valueOf(random.nextInt(fin - inicio + 1) + inicio);
				}
			} catch (Exception e) {
				return "#Error#";
			}
		} else if (mensaje.equals("#Fin#")) {

			return "#Finalizado#";
		}
		return "#Error#";
	}

}
