package copiasMemoriaExamen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket4 {
	
	private ServerSocket serverSocket;
	private int port;
	
	public ServerSocket4(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	public static void main(String[] args) {
		
		ServerSocket serverS = null;
		
		try {
			serverS = new ServerSocket(8083);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		
		while(true) {
			
			Socket socket = null;
			try {
				socket = serverS.accept();
				System.out.println("(Server)Conexion aceptada.");
				new Thread(new GestorSocket4(socket)).start();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
		}
	}
	
	


}
