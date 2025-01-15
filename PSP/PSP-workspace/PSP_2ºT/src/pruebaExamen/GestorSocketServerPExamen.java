package pruebaExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class GestorSocketServerPExamen implements Runnable {

	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public GestorSocketServerPExamen(Socket socket) {
		this.socket = socket;
	}
	
	private String procesarMensaje(String mensaje) {
        if (mensaje.startsWith("#Listado números#")) {
        	
            String[] partes = mensaje.split("#");
            
            if (partes.length == 4) {
                try {
                    int inicio = Integer.parseInt(partes[2]);
                    int fin = Integer.parseInt(partes[3]);
                    if (inicio > fin) return "#Error#";
                    String resultado = "";
                    for (int i = inicio; i <= fin; i++) {
                        resultado += i + "|"; // Usamos concatenación directa
                    }
                    return resultado.substring(0, resultado.length() - 1); // Quitamos el último "|"
                } catch (NumberFormatException e) {
                    return "#Error#";
                }
            }
        } else if (mensaje.startsWith("#Numero aleatorio#")) {
            String[] partes = mensaje.split("#");
            if (partes.length == 4) {
                try {
                    int inicio = Integer.parseInt(partes[2]);
                    int fin = Integer.parseInt(partes[3]);
                    if (inicio > fin) return "#Error#";
                    Random random = new Random();
                    return String.valueOf(random.nextInt(fin - inicio + 1) + inicio);
                } catch (NumberFormatException e) {
                    return "#Error#";
                }
            }
        } else if (mensaje.equals("#Fin#")) {
            return "#Finalizado#";
        }
        return "#Error#";
    }

	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			pw = new PrintWriter(os, true);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

		
			String mensaje;
			
		while ((mensaje = br.readLine()) != null) {
			
			System.out.println("Petición recibida: " + mensaje);
			
			String respuesta = procesarMensaje(mensaje);
			
			System.out.println("Respuesta enviada: " + respuesta);
			
			pw.println(respuesta);

			if (respuesta.equals("#Finalizado#")) {
				break;
			}
		}
		} catch (IOException e) {
			System.out.println("(Gestor sockets) Error abriendo streams del socket");
			return;
		}

		try {
			pw.close();
			br.close();
			isr.close();
			is.close();
			os.close();
		} catch (IOException e) {
			System.out.println("(Gestor sockets) Error cerrando streams del socket");
		}

	}

}
