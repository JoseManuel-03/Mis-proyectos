package paquete_3;

import java.lang.Thread.State;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreadManager {
	private static final long milis = 90;
	private List<Thread> threads = new ArrayList<>();
	private TreeMap<Long, String> threadStates = new TreeMap<>();
	private List<Thread.State> listaEstados = new ArrayList<>();

	public void startThreads() {
		CountDown cont1 = new CountDown("C1", 10);
		CountDown cont2 = new CountDown("C2", 8);
		CountDown cont3 = new CountDown("C3", 7);

		Thread c1 = new Thread(cont1);
		Thread c2 = new Thread(cont2);
		Thread c3 = new Thread(cont3);

		threads.add(c1);
		threads.add(c2);
		threads.add(c3);

		// Crea tres hilos CountDown con diferentes valores iniciales
		// y añádelos a la lista threads. Valores:
		// - "C1", 10
		// - "C2", 8
		// - "C3", 7

		// Inicia los hilos recorriendo la lista threads

		for (Thread thread : threads) {
			thread.start();
		}
		// Guarda el estado de cada hilo en el Map

		threadStates.put(System.currentTimeMillis(), "C1");
		threadStates.put(System.currentTimeMillis(), "C2");
		threadStates.put(System.currentTimeMillis(), "C3");

	}

	public void monitoreaThreads() throws InterruptedException {
		boolean allThreadsTerminated = false;

		CountDown cont1 = new CountDown("C1", 10);
		CountDown cont2 = new CountDown("C2", 8);
		CountDown cont3 = new CountDown("C3", 7);

		Thread c1 = new Thread(cont1);
		Thread c2 = new Thread(cont2);
		Thread c3 = new Thread(cont3);

		threads.add(c1);
		threads.add(c2);
		threads.add(c3);

		Thread.State estados;

		while (allThreadsTerminated) {
			try {
				estados = c1.getState();
				estados = c2.getState();
				estados = c3.getState();

				listaEstados.add(estados);
				Thread.sleep(milis);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Monitorea hasta que todos los hilos hayan terminado.
		// Para ello cada 90 milisegundos aproximadamente
		// almacena en el map para cada hilo la información:
		// - clave -> timestamp
		// - valor -> cadena con nombre y estado
		// - ejemplo de la cadena: C1:RUNNABLE
		// y vefica si todos han terminado.
	}

	public void printThreadStates() {
		// Imprimir todos los estados registrados en el TreeMap
		System.out.println("\nResumen de estados de los hilos:");
		for (State state : listaEstados) {
			System.out.println(state);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadManager manager = new ThreadManager();
		manager.startThreads();
		manager.monitoreaThreads();
		manager.printThreadStates();
		// Responde brevemente a las siguientes preguntas:
		// 1.- Motivo de la frecuencia del estado RUNNABLE
		// 2.- Motivo de la frecuencia del estado TIMED_WAITING
		// 3.- Motivo de la frecuencia del estado TERMINATED
		System.out.println("Respuestas a las preguntas");
		System.out.println("1: Hilo arrancado pero puede estar o no funcionando");
		System.out.println("2: En espera debido a Thread.sleep()");
		System.out.println("3: Terminado");
	}
}
