package paquete;

public class BotellaMonohilo {

	private String nombre;
	private char carácter;
	private int cantidad;
	private static long millis = 300;

	public BotellaMonohilo(String nombre, char carácter, int cantidad) {
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

	public static void main(String[] args) {
		BotellaMonohilo botella1 = new BotellaMonohilo("b-1", '*', 10);
		botella1.vaciar();
		BotellaMonohilo botella2 = new BotellaMonohilo("b-2", '-', 10);
		botella2.vaciar();
	}

}
