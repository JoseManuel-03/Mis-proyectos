package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServerCiclicoLetras {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int port;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public SocketServerCiclicoLetras(int port) throws IOException {
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

	public void abrirCanalesTexto() {
		System.out.println("[Servidor] Abriendo canales de texto...");
		pw = new PrintWriter(os, true);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.println("[Servidor] Canales de texto abiertos...");
	}

	public void cerrarCanalesTexto() throws IOException {
		System.out.println("[Servidor] Cerrando canales de texto...");
		pw.close();
		br.close();
		isr.close();
		System.out.println("[Servidor] Canales de texto cerrados...");
	}

	public static void main(String[] args) throws IOException {
		SocketServerCiclicoLetras server = new SocketServerCiclicoLetras(8081);
		server.start();
		server.abrirCanalesTexto();
		try {
			String datoBuscar = "fin";
			String datoLeido = server.br.readLine();


			if (datoBuscar.equalsIgnoreCase(datoLeido)) {
				System.out.println("[Servidor] TEXTO CORRECTO");
				server.cerrarCanalesTexto();
				server.stop();
			}

			String datoMandar = datoLeido.toUpperCase();
			server.pw.println(datoMandar);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
