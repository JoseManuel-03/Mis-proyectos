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
		SocketClientPExamen clientPExamen;

		try {
			clientPExamen = new SocketClientPExamen("localhost", 8081);
			for (int i = 1; i <= 1000; i++) {
				String datoEnviado = Integer.toString(i);
				clientPExamen.pw.println(datoEnviado);
				String datoRecibido = clientPExamen.br.readLine();
				clientPExamen.intentos++;
				if ("Acertado".equals(datoRecibido)) {
					System.out.printf("(Cliente) Dato acertado después de %d intentos%n", clientPExamen.intentos);
					break;
				}
			}
			// Cierre de los streams del cliente
			clientPExamen.pw.close();
			clientPExamen.br.close();
			clientPExamen.isr.close();
			clientPExamen.os.close();
			clientPExamen.is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
