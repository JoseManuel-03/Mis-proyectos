package copiasMemoriaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorSocket2 implements Runnable {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private InputStreamReader isr;
	private PrintWriter pw;
	private BufferedReader br;

	public GestorSocket2(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream())) {

			String mensaje;

			while (((mensaje = in.readLine()) != null)) {
				System.out.println("Mensaje recibido: " + mensaje);
				String respuesta = procesarMensaje(mensaje);
				System.out.println("Respuesta enviada: " + respuesta);
				out.println(respuesta);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("Conexion cerrada");

	}

	private String procesarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		return null;
	}

}
