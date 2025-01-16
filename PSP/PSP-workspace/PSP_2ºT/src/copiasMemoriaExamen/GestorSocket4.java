package copiasMemoriaExamen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorSocket4 implements Runnable {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw;

	public GestorSocket4(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

			String mensaje;
			boolean numeroAdivinado = false;

			while ((mensaje = in.readLine()) != null) {

				if (!numeroAdivinado) {

					try {
						String respuesta = adivinarNumero(Integer.parseInt(mensaje));
						out.println(respuesta);

						if (respuesta.equals(
								"¡Adiviné el número!, Ahora dime una palabra para ver si es palínfromo o no lo es")) {
							numeroAdivinado = true;
						}

					} catch (NumberFormatException e) {
						out.println("Numero invalido, ponga otro numero ");
					}

				} else {
					String respuesta = esPalindromo(mensaje);
					out.println(respuesta);

				}

			}

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
