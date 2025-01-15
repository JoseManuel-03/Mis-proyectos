package pruebaExamen2Exam;

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

	private String serverIP;
	private int serverPort;
	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public SocketClientPExamen(String serverIP, int serverPort) throws UnknownHostException, IOException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		socket = new Socket(serverIP, serverPort);
		os = socket.getOutputStream();
		is = socket.getInputStream();
		pw = new PrintWriter(os, true);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			SocketClientPExamen clientPExamen = new SocketClientPExamen("localhost", 8082);
			SocketClientPExamen clientPExamen2 = new SocketClientPExamen("localhost", 8082);

			System.out.print("Introduce una palabra para verificar si es palíndromo: ");
			String mensajes = scanner.nextLine();
			clientPExamen.pw.println(mensajes);
			clientPExamen2.pw.println(mensajes);

			String respuesta = clientPExamen.br.readLine();
			String respuesta2 = clientPExamen2.br.readLine();

			System.out.println("Mensaje enviado: " + mensajes);
			System.out.println("Mensaje recibido: " + respuesta);
			System.out.println("Mensaje recibido 2: " + respuesta2);

			System.out.print("Introduce un número entre 1 y 10 para la adivinanza: ");
			int numeroAdivinanza = scanner.nextInt();
			scanner.nextLine();

			clientPExamen.pw.println(numeroAdivinanza);

			String respuestaAdivinanza;
			while (!(respuestaAdivinanza = clientPExamen.br.readLine()).equals("¡Adivinaste el número!")) {
				
				System.out.println(respuestaAdivinanza);
				
				String respuestaCliente = scanner.nextLine();
				clientPExamen.pw.println(respuestaCliente);
			}

			clientPExamen.pw.close();
			clientPExamen.br.close();
			clientPExamen.isr.close();
			clientPExamen.os.close();
			clientPExamen.is.close();
			clientPExamen2.pw.close();
			clientPExamen2.br.close();
			clientPExamen2.isr.close();
			clientPExamen2.os.close();
			clientPExamen2.is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
