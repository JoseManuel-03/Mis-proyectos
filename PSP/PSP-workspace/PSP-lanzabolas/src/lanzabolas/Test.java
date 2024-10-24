package lanzabolas;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {

		        // Crear un ExecutorService con un pool fijo de 3 hilos
		        ExecutorService executor1 = Executors.newFixedThreadPool(3);
		        ExecutorService executor2 = Executors.newFixedThreadPool(1);
		        ExecutorService executor3 = Executors.newFixedThreadPool(9);

		        // Crear instancias de Lanzabolas
		        LanzaBolas lanzador1 = new LanzaBolas(" Lanzador1 ");
		        LanzaBolas lanzador2 = new LanzaBolas(" Lanzador2 ");
		        LanzaBolas lanzador3 = new LanzaBolas(" Lanzador3 ");

		  
		        
		        System.out.println("Pool fijo de 1 con 9 tareas");
		        
		        for(int i = 0; i < 3; i++) {
			        executor2.execute(lanzador1);
			        executor2.execute(lanzador2);
			        executor2.execute(lanzador3);
		        }
		       
		        executor1.shutdown();
		        executor2.shutdown();
		        executor3.shutdown();
	}
}