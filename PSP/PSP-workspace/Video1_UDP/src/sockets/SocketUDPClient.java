package sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketUDPClient {
	public static void main(String[] args) {
		String strMensaje = "Mensaje enviado desde el cliente";
		DatagramSocket socketUDP;
		
			System.out.println("(Cliente) Estableciendo parámentros de conexión ...");
			
			InetAddress hostServidor;
			try {
				hostServidor = InetAddress.getByName("localhost");

			int puertoServidor = 49171;
			
			System.out.println("(Cliente) Creando socket ...");
			
			socketUDP = new DatagramSocket();
			
			System.out.println("(Cliente) Enviando datagrama ...");
			
			byte[] msg = strMensaje.getBytes();
			DatagramPacket peticion = new DatagramPacket(msg, msg.length, hostServidor, puertoServidor);
			socketUDP.send(peticion);
			
			System.out.println("(Cliente) Recibiendo datagrama ...");
			
			byte[] buffer = new byte[64];
			DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, hostServidor, puertoServidor);
			socketUDP.receive(respuesta);
			
			System.out.println("(Cliente) Mensaje recibido: " + new String(buffer));
			System.out.println("(Cliente) Cerrando socket ...");
			
			socketUDP.close();
			System.out.println("(Cliente) Socket cerrado.");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}