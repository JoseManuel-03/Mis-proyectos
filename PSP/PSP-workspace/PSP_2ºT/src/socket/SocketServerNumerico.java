package socket;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerNumerico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int port;

	public SocketServerNumerico(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("[Servidor] Esperando conexion...");
		socket = serverSocket.accept();
		System.out.println("[Servidor] Conexion establecida...");
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("[Servidor] Cerrando conexion...");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("[Servidor] Conexion cerrada");

	}

	public static void main(String[] args) {
		SocketServerNumerico server;
		try {
			server = new SocketServerNumerico(8081);
			server.start();
			int datoLeido = server.is.read();
			System.out.println("[Servidor] Dato recibido: " + datoLeido);
			int datoADevolver = datoLeido + 1;
			server.os.write(datoADevolver);
			System.out.println("[Servidor] Dato enviado: " + datoADevolver);
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
