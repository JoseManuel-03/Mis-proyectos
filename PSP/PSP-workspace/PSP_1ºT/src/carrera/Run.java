package carrera;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		Carrera carrera = new Carrera(1000);
		/*
		 * Coche cocheAlonso = new Coche("C-1", 100, carrera); Coche cocheAlonsito = new
		 * Coche("C-2", 100, carrera); Coche cocheNano = new Coche("C-3", 100, carrera);
		 * 
		 * Thread t1 = new Thread(cocheAlonso); Thread t2 = new Thread(cocheAlonsito);
		 * Thread t3 = new Thread(cocheNano);
		 * 
		 * t1.start(); t2.start(); t3.start();
		 * 
		 * t1.join(); t2.join(); t3.join();
		 * 
		 * carrera.imprimirPodio();
		 */

		int numCoches = 10_000;

		ThreadGroup tg = new ThreadGroup("grupito");
		List<Thread> hilos = new ArrayList<>();
		for (int i = 0; i < numCoches; i++) {
			Thread t = new Thread(tg, new Coche("C" + i, 100, carrera));
			t.start();
			hilos.add(t);
		}
		try {
			for (Thread thread : hilos) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(tg.activeCount());
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carrera.imprimirPodio();

	}
}