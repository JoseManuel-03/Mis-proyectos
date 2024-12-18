package botella;

public class BotellaMultihiloRunnable implements Runnable{

	private String nombre;
	private char carácter;
	private int cantidad;
	private static long millis = 300;

	public BotellaMultihiloRunnable(String nombre, char carácter, int cantidad) {
		this.nombre = nombre;
		this.carácter = carácter;
		this.cantidad = cantidad;
	}

	public void vaciar() {
		while (cantidad > 0) {
			System.out.print(carácter);
			cantidad--;
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		vaciar();	
	}

	public static void main(String[] args) {
		BotellaMultihiloRunnable botella1 = new BotellaMultihiloRunnable("b1", '*', 10);
		new Thread(botella1).start();
		
		BotellaMultihiloRunnable botella2 = new BotellaMultihiloRunnable("b2", '-', 10);
		new Thread(botella2).start();
	

	}

}
