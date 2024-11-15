package lanzabolas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzabolas implements Runnable {

	private String nombre;

	public Lanzabolas(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("Lanzabolas: " + nombre);

	}

	public static void main(String[] args) {
		Lanzabolas l1 = new Lanzabolas("L1");
		Lanzabolas l2 = new Lanzabolas("L2");
		Lanzabolas l3 = new Lanzabolas("L3");

		ExecutorService executor1 = Executors.newFixedThreadPool(3);
		ExecutorService executor2 = Executors.newFixedThreadPool(1);
		ExecutorService executor3 = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 3; i++) {
			executor1.execute(l1);
			executor2.execute(l2);
			executor3.execute(l3);

		}
		
		executor1.shutdown();
		executor2.shutdown();
		executor3.shutdown();

	}

}
