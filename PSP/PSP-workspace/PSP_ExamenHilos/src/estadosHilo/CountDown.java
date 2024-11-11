package estadosHilo;

public class CountDown implements Runnable {

	private static final long milis = 1000;
	private int start;
	private String name;

	public CountDown(int start, String name) {
		super();
		this.start = start;
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getMilis() {
		return milis;
	}

	@Override
	public void run() {
		for (int i = start; i >= 0; i--) {
			System.out.printf(name, i);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		CountDown c1 = new CountDown(3, " C1 ");

		Thread hiloNoArrancado = new Thread(c1);

		// NEW: hilo creado pero no arrancado
		System.out.println(hiloNoArrancado.getName() + " " + hiloNoArrancado.getState()); // STATE PARA VER EL ESTADO
																							// DEL HILO
		hiloNoArrancado.start();

		// RUNNABLE: hilo arrancado pero puede estar o no funcionando
		System.out.println(hiloNoArrancado.getName() + " " + hiloNoArrancado.getState());

		while (hiloNoArrancado.isAlive()) {
			// TIMED_WAITING: en espera debido a Thread.sleep()
			System.out.println(" TIMED_WAITING "+hiloNoArrancado.getName() + " " + hiloNoArrancado.getState());
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// TERMINATED: terminado
        System.out.printf(hiloNoArrancado.getName() + " " + hiloNoArrancado.getState());
	}

}
