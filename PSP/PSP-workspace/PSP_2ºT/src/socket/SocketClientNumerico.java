package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientNumerico {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClientNumerico(String address, int port) {
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
		System.out.println("[Client] Cerrando conexion..." + address + port);
		is.close();
		os.close();
		socket.close();
		System.out.println("[Client] Conexion cerrada" + address + port);

	}

	public static void main(String[] args) {
		SocketClientNumerico client;
		client = new SocketClientNumerico("localhost", 8081);

		try {
			client.start();
			int datoAEnviar = new Random().nextInt(255);
			client.os.write(datoAEnviar);
			System.out.println("[Client] Enviado " + datoAEnviar + " a " + client.address + " " + client.port);

			int datoRecibido = client.is.read();

			System.out.println("[Client] Recibido " + datoRecibido + " de " + client.address + " " + client.port);

			client.stop();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
