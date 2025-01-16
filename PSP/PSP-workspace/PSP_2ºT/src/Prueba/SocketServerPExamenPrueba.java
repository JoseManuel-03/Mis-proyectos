package Prueba;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerPExamenPrueba {

	private ServerSocket serverSocket;
	private int port;

	public SocketServerPExamenPrueba(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverS = null;
		try {
			serverS = new ServerSocket(8083);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		while (true) {
			Socket miSocket = null;
			try {
				miSocket = serverS.accept();
				System.out.println("(Servidor)Socket aceptado.");
				new Thread(new GestorSocketServerPExamenPrueba(miSocket)).start();

			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

	}
	
	

}
