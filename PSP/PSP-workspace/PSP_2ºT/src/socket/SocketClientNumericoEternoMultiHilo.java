package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientNumericoEternoMultiHilo {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClientNumericoEternoMultiHilo(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("[Client] Lanzando peticion al server");
		socket = new Socket(address, port);
		System.out.println("[Client] Conexion establecida" + address + port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("[Client] Cerrando conexión" + address + port);
		is.close();
		os.close();
		socket.close();
		System.out.println("[Client] Conexión cerrada" + address + port);
	}

	public static void main(String[] args) {
		SocketClientNumericoEternoMultiHilo cliente = new SocketClientNumericoEternoMultiHilo("localhost", 8081);

		try {
			cliente.start();
			for (int i = 0; i < 255; i++) {
				Integer datoEnviar = i;
				cliente.os.write(datoEnviar);
				Integer datorRecibido = cliente.is.read();
				if (datorRecibido == 255) {
					System.out.println("[Client] El cliente ha enviado 255, terminando la comunicación");
					break;
				}
				if (datorRecibido - datoEnviar == 1) {
					System.out.println("Recibido BIEN");
				} else {
					System.out.println("Recibido MAL");
				}
			}
			cliente.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
