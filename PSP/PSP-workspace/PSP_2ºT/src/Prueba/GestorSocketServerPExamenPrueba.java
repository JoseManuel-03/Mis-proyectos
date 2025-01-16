package Prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorSocketServerPExamenPrueba implements Runnable {

	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public GestorSocketServerPExamenPrueba(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

			boolean numeroAdivinado = false;

			String mensaje;
			while ((mensaje = in.readLine()) != null) {
				
				if (!numeroAdivinado) {
					try {
						int numero = Integer.parseInt(mensaje);
						String respuesta = adivinarNumero(numero);
						out.println(respuesta);

						if (respuesta.equals("¡Adiviné el número!, Ahora dime una palabra para ver si es palínfromo o no lo es")) {
							numeroAdivinado = true;
						}
					} catch (NumberFormatException e) {
						out.println("Por favor, ingresa un número válido.");
					}
				} else {
					String respuesta = esPalindromo(mensaje);
					out.println(respuesta);
					
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
			respuesta = "¡Adiviné el número!, Ahora dime una palabra para ver si es palínfromo o no lo es";
		}
		return respuesta;
	}

}
