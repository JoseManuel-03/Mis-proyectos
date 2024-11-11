package estadosHilosLista;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

public class CountDown2 implements Runnable {

	private static final long milis = 1000;
	private int start;
	private String name;

	public CountDown2(int start, String name) {
		super();
		this.start = start;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = start; i >= 0; i--) {
			System.out.println(name + i);
		}

		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CountDown2 c1 = new CountDown2(5, "C1");
		List<Thread.State> listaEstados = new ArrayList<>();
		Thread.State estados;

		Thread hilo = new Thread(c1);

		
		estados = hilo.getState();
		listaEstados.add(estados);
		System.out.println(estados);
		
		hilo.start();
		estados = hilo.getState();
		listaEstados.add(estados);
		System.out.println(estados);
		
		
		while (hilo.isAlive()) {
			estados = hilo.getState();
			listaEstados.add(estados);
			System.out.println(estados);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		listaEstados.add(estados);
		
		
		System.out.println("Estados de los hilos");
		
		for (State state : listaEstados) {
			
			System.out.println(state);
			
		}
		System.out.println(listaEstados.size());
		
	}

}
