package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientCiclicoLetrasFIN {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public SocketClientCiclicoLetrasFIN(String address, int port) throws IOException {
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
		serverSocket.close();
		System.out.println("[Client] Conexion cerrada" + address + port);
	}

	public void abrirCanalesTexto() {
		System.out.println("[Client] Abriendo canales de texto...");
		pw = new PrintWriter(os, true);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.println("[Client] Canales de texto abiertos...");
	}

	public void cerrarCanalesTexto() throws IOException {
		System.out.println("[Client] Cerrando canales de texto...");
		pw.close();
		br.close();
		isr.close();
		System.out.println("[Client] Canales de texto cerrados...");
	}

	public static void main(String[] args) throws IOException {
		SocketClientCiclicoLetrasFIN cliente;
		cliente = new SocketClientCiclicoLetrasFIN("localhost", 8081);
		String datoEnviar = "fin";

		try {
			cliente.start();
			cliente.abrirCanalesTexto();

			cliente.pw.println(datoEnviar);
			String datoRecibido = cliente.br.readLine();
			System.out.println("[Client] " + datoRecibido);

			if (datoEnviar.equalsIgnoreCase(datoRecibido)) {
				cliente.cerrarCanalesTexto();
				cliente.stop();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
