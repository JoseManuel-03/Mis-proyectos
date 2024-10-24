package paquete;

public class BotellaMultihilo extends Thread {

	private String nombre;
	private char carácter;
	private int cantidad;
	private static long millis = 300;

	public BotellaMultihilo(String nombre, char carácter, int cantidad) {
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
		BotellaMultihilo botella1 = new BotellaMultihilo("b-1", '*', 10);
		botella1.start();
		BotellaMultihilo botella2 = new BotellaMultihilo("b-2", '-', 10);
		botella2.run();
	}

}
