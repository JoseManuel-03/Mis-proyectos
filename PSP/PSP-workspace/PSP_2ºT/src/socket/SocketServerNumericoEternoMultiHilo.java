package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerNumericoEternoMultiHilo {

	private ServerSocket serverSocket;
	private int port;

	public SocketServerNumericoEternoMultiHilo(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("[Servidor] Esperando conexion...");
		Socket socket = serverSocket.accept();
		new Thread(new ClienteHandler(socket)).start();

	}

	public void stop() throws IOException {
		serverSocket.close();
		System.out.println("[Servidor] Conexion cerrado");

	}

	private class ClienteHandler implements Runnable {
		private Socket socket;
		private InputStream is;
		private OutputStream os;

		public ClienteHandler(Socket socket) throws IOException {
			this.socket = socket;
			this.is = socket.getInputStream();
			this.os = socket.getOutputStream();
		}

		public void run() {
			try {
				System.out.println("[Servidor] Conexion establecida" + socket.getInetAddress());
				while (true) {
					Integer datoLeido = is.read();
					if (datoLeido == 255) {
						System.out.println("[Servidor] Terminando establecida" + socket.getInetAddress());
						break;
					}
					System.out.println("[Servidor] Dato recibido: " + datoLeido);
					Integer datoDevolver = ++datoLeido;
					os.write(datoDevolver);
					System.out.println("[Servidor] Dato enviado: " + datoDevolver);
				}
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {
		SocketServerNumericoEternoMultiHilo serverNumericoEternoMultiHilo;
		try {
			serverNumericoEternoMultiHilo = new SocketServerNumericoEternoMultiHilo(8081);
			serverNumericoEternoMultiHilo.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
