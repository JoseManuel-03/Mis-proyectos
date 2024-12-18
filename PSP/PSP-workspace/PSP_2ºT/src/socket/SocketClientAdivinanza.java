package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientAdivinanza {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClientAdivinanza(String address, int port) throws IOException {
		this.address = address;
		this.port = port;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando peticion al server...");
		socket = new Socket(address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("[Client] Peticion aceptada...");

	}

	public void stop() throws IOException {
		System.out.println("[Servidor] Cerrando conexion..." + address + port);
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("[Servidor] Conexion cerrada" + address + port);
	}

	public static void main(String[] args) throws IOException {
		SocketClientAdivinanza adivinanza;
		adivinanza = new SocketClientAdivinanza("localhost", 8081);
		adivinanza.start();
		int numeroEnviar = new Random().nextInt(5);
		try {
			while (true) {
				adivinanza.os.write(numeroEnviar);
				int numeroRecibido = adivinanza.is.read();
				if (numeroRecibido == 200) {
					System.out.println("[Cliente] Nuevo intento");
					adivinanza.os.write(numeroEnviar ++);

				} else if (numeroRecibido == 300) {
					System.out.println("[Cliente] Nuevo intento");
					if(numeroEnviar > 0 ) {
					adivinanza.os.write(numeroEnviar --);
					}

				} else {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		adivinanza.stop();
	}

}
