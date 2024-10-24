package paquete;

public class LanzadorThread extends Thread {

	private BotellaMultihilo botellita;

	public LanzadorThread(BotellaMultihilo botellita) {
		this.botellita = botellita;
	}

	public void run() {
		botellita.vaciar();
	}

	public static void main(String[] args) {
		BotellaMultihilo botella1 = new BotellaMultihilo("b-1", '*', 10);
		new LanzadorThread(botella1).start();
		BotellaMultihilo botella2 = new BotellaMultihilo("b-2", '-', 10);
		new LanzadorThread(botella2).start();

	}

}
