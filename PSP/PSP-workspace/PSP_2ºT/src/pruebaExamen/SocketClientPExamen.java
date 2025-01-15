package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientPExamen {

	public static void main(String[] args) {

		try (Socket socket = new Socket("localhost", 8083);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				Scanner scanner = new Scanner(System.in)) {

			System.out.println("Conectado al servidor. Escribe un mensaje:");
			while (true) {
				System.out.print("Mensaje: ");
				String mensaje = scanner.nextLine();
				out.println(mensaje);
				String respuesta = in.readLine();
				System.out.println("Mensaje recibido: " + respuesta);
				if (respuesta.equals("#Finalizado#")) {
					System.out.println("Fin de la conexión.");
					break;
				} else if (respuesta.equals("#Error#")) {
					System.out.println("Mensaje no adecuadamente formateado para su tratamiento.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
