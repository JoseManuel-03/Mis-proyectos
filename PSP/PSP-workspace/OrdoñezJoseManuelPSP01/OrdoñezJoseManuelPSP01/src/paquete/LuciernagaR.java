
package paquete;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuciernagaR implements Runnable {

	private String nombre;
	private Boolean encendido;
	private int energia;
	private static int milis = 1000;

	public LuciernagaR(String nombre, int energia) {
		super();
		this.nombre = nombre;
		if (energia <= 50 && energia >= 1) {
			this.energia = energia;
		}
		encendido = false;
	}

	public void enciende() {
		while (energia > 0) {
			if (encendido == false) {
				System.out.println("Se reduce la energia 1 unidad, energía actual: " + energia);
				energia--;
				encendido = true;
			}
			System.out.println("Se reduce la energia 1 unidad, energía actual: " + energia);
			energia--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void run() {
		enciende();
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		LuciernagaR l1 = new LuciernagaR("luciernaga1", 10);
		executor.submit(l1);

		LuciernagaR l2 = new LuciernagaR("luciernaga2", 7);
		executor.submit(l2);

		LuciernagaR l3 = new LuciernagaR("luciernaga3", 9);
		executor.submit(l3);

		executor.shutdown();

	}
}
