package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientPExamen {

	private String serverIP;
	private int serverPort;
	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	private int intentos;

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

		String[] mensajes = { "#Listado números#2#11#", "#Numero aleatorio#3#20#", "#Fin#", "Mensaje inválido" };
		try {
			SocketClientPExamen clientPExamen = new SocketClientPExamen("localhost", 8082);
			SocketClientPExamen clientPExamen2 = new SocketClientPExamen("localhost", 8082);

			for (String mensaje : mensajes) {

				clientPExamen.pw.println(mensaje);
				clientPExamen2.pw.println(mensaje);
				
				String respuesta = clientPExamen.br.readLine();
				String respuesta2 = clientPExamen2.br.readLine();

				System.out.println("Mensaje enviado: " + mensaje);
				System.out.println("Mensaje recibido: " + respuesta);
				System.out.println("Mensaje recibido 2: " + respuesta2);

				if ("#Finalizado#".equals(respuesta)) {
					System.out.println("Fin de la conexión");
					break;
				} else if ("#Error#".equals(respuesta)) {
					System.out.println("Mensaje no adecuadamente formateado para su tratamiento.");
				}
				
				if ("#Finalizado#".equals(respuesta2)) {
					System.out.println("Fin de la conexión 2");
					break;
				} else if ("#Error#".equals(respuesta2)) {
					System.out.println("Mensaje 2 no adecuadamente formateado para su tratamiento.");
				}
			}

			// Cierre de los streams del cliente
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
