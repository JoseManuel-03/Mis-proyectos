package pruebaExamen2Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

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

	public String esPalindromo(String mensaje) {

		int longitud = mensaje.length();

		for (int i = 0; i < longitud / 2; i++) {
			if (!mensaje.substring(i, i + 1).equals(mensaje.substring(longitud - 1 - i, longitud - i))) {
			} else {
				return "La palabra " + mensaje + " es palindromo";
			}
		}
		return "La palabra " + mensaje + " no es palindromo";

	}

	public String adivinarNumero(int numero) {

		int adivinar = 8;

		String respuesta = "";

		if (adivinar < numero) {

			respuesta = "Número menor";

		} else if (adivinar > numero) {

			respuesta = "Número mayor";

		} else {
			respuesta = "¡Adiviné el número!";
		}
		return respuesta;
	}

	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			pw = new PrintWriter(os, true);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String mensaje;

			while ((mensaje = br.readLine()) != null) {
				System.out.println("Petición recibida: " + mensaje);
				try {

					int numero = Integer.parseInt(mensaje);
					String respuesta = adivinarNumero(numero);
					System.out.println("Respuesta enviada: " + respuesta);

					pw.println(respuesta);

					if (respuesta.equals("¡Adiviné el número!")) {
						break;
					}
				} catch (Exception e) {
					String respuesta = esPalindromo(mensaje);
					pw.println(respuesta);
				}
			}
		} catch (IOException e) {
			System.out.println("(Gestor sockets) Error abriendo streams del socket");
			return;
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
