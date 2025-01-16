package pruebaExamen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestor implements Runnable {

	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public Gestor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
