package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

public class GestorSocketServerPExamen implements Runnable {

	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	private static AtomicLong peticionesAlServidor = new AtomicLong(0);

	public GestorSocketServerPExamen(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			pw = new PrintWriter(os, true);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		} catch (IOException e) {
			System.out.println("(Gestor sockets) Error abriendo streams del socket");
			return;
		}
		while (true) {
			String datoLeido;
			try {
				datoLeido = br.readLine();
				peticionesAlServidor.getAndIncrement();
				if (datoLeido.equals(datoLeido)) {

				}
			} catch (IOException e) {
				System.out.println("(Gestor sockets) Error leyendo el buffered reader");
				break; // Salir del bucle en caso de error de E/S
			}

			try {
				pw.close();
				br.close();
				isr.close();
				is.close();
				os.close();
			} catch (IOException e) {
				System.out.println("(Gestor sockets) Error cerrando streams del socket");
			}

		}
	}

}
