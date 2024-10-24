package paquete;

public class LuciernagaT extends Thread {

	private String nombre;
	private Boolean encendido;
	private int energia;
	private static int milis = 500; 

	public LuciernagaT(String nombre, int energia) {
		super();
		this.nombre = nombre;
		if (energia <= 50 && energia >= 1) {
			this.energia = energia;
		}
		encendido = false;
	}

	public void enciende() {
		while (energia > 0) {
			if (encendido == false) {
				System.out.println("Se reduce la energia 1 unidad, energía actual: " + energia);
				energia--;
				encendido = true;
			}
			System.out.println("Se reduce la energia 1 unidad, energía actual: " + energia);
			energia--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		enciende();
	}

	public static void main(String[] args) {
		LuciernagaT l1 = new LuciernagaT("luciernaga1", 10);
		l1.start();
		LuciernagaT l2 = new LuciernagaT("luciernaga2", 7);
		l2.start();
		LuciernagaT l3 = new LuciernagaT("luciernaga3", 9);
		l3.start();

	}
}

