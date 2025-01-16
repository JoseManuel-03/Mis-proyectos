package copiasMemoriaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorSocket1 implements Runnable {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private BufferedReader br;
	private PrintWriter pw;
	private InputStreamReader isr;

	public GestorSocket1(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

			String mensaje;
			while ((mensaje = in.readLine()) != null) {
				
				String respuesta = procesoMensaje(mensaje);
				out.println(respuesta);

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

	private String procesoMensaje(String mensaje) {
		// TODO Auto-generated method stub
		return null;
	}

}
