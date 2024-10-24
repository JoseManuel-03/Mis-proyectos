package lanzabolas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LanzaBolas implements Runnable{
	
	private String nombre;
	
	

	public LanzaBolas(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void run() {
	   LocalDateTime ahora = LocalDateTime.now();
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM:ss.SSS");
	   System.out.println("Lanzando bola desde "+ nombre +"a las"+  ahora.format(formatter));
	}
}
