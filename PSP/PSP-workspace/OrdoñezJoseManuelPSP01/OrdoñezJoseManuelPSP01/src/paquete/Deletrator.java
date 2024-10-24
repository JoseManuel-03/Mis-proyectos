package paquete;

public class Deletrator implements Runnable {

	private String palabra;
	private static int milis = 1000;

	public Deletrator(String palabra) {
		super();
		this.palabra = palabra;
	}

	public void deletrear() {

		for (int i = 0; i < palabra.length(); i++) {
			String recorridoPalabra = "";
			for (int j = 0; j < palabra.length(); j++) {
				if (j == i) {
					recorridoPalabra += palabra.substring(j, j + 1);
				} else {
					recorridoPalabra += "-";
				}

			}
			System.out.println("Deletreando " + palabra + " [" + recorridoPalabra + "]");
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
	}

	@Override
	public void run() {
		deletrear();

	}

	public static void main(String[] args) {
		String palabra = "HOLA";
		Deletrator deletrator = new Deletrator(palabra);
		Thread hilo = new Thread(deletrator);
		hilo.start();

	}

}
