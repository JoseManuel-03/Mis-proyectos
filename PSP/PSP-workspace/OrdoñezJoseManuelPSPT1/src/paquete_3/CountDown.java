package paquete_3;

public class CountDown implements Runnable {
	private static final long milis = 100;
	private int start;
	private String name;

	public CountDown(String name, int start) {
		this.start = start;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = start; i >= 0; i--) {
			System.out.printf("%s: %d%n", name, i);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.printf("%s fue interrumpido!%n", name);
				break;
			}
		}
	}
}
