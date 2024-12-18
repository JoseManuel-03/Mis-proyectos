package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServerAdivinanza {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int port;

	public SocketServerAdivinanza(int port) throws IOException {
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

	public static void main(String[] args) throws IOException {
		SocketServerAdivinanza server = new SocketServerAdivinanza(8081);
		server.start();
		try {
			Integer numeroAdivinar = new Random().nextInt(5);
			int numeroDevolver = 0;
			while (true) {
				int intento = server.is.read();
				System.out.println("[Servidor] Intento de adivinanza: " + intento);

				if (intento < numeroAdivinar) {
					System.out.println("[Servidor] El intento fue demasiado bajo");
					numeroDevolver = 200;
					server.os.write(numeroDevolver);

				} else if (intento > numeroAdivinar) {
					System.out.println("[Servidor] El intento fue demasiado alto");
					numeroDevolver = 300;
					server.os.write(numeroDevolver);

				} else if (intento == numeroAdivinar) {
					System.out.println("[Servidor] El intento fue CORRECTO");
					numeroDevolver = 250;
					server.os.write(numeroDevolver);
					break;
				}
			}
			server.stop();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
