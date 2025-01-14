package pruebaExamen;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerPExamen {

	private ServerSocket serverSocket;
	private int port;
	private static long socketAceptados = 0;

	public SocketServerPExamen(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public static long getSocketAceptados() {
		return socketAceptados;
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverS = null;
		try {
			serverS = new ServerSocket(8082);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		while (true) {
			Socket miSocket = null;
			try {
				miSocket = serverS.accept();
				System.out.println("(Servidor)Socket aceptado.");
				socketAceptados++;
				new Thread(new GestorSocketServerPExamen(miSocket)).start();
				
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

	}

}
