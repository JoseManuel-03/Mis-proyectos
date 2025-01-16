package copiasMemoriaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient1 {
	
	public static void main(String[] args) {
		
		try(Socket socket = new Socket("localhost", 8083);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				Scanner scanner = new Scanner(System.in)) {
			
			System.out.println("Conectado al servidor. Escribe un mensaje:");
			
			while(true) {
				
				System.out.print("Mensaje: ");
				
				String mensaje = scanner.nextLine();
				out.println(mensaje);
				
				String respuesta = in.readLine();
				
				System.out.println("Mensaje recibido: " + respuesta);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
