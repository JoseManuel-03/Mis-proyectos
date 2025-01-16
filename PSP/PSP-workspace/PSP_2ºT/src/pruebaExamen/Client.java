package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		try(Socket socket = new Socket("localhost", 8083);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in)){
			
			while(true) {
				
				String mensaje = scanner.nextLine();
				out.println(mensaje);
				String respuesta = in.readLine();
				System.out.println("Mensaje recibido: "+ respuesta);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
