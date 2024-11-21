package paquete;

public class LCountDown {
	public void lanzarCuentaAtras(int start) {
		Runnable cuentaAtrasRunnable = new Runnable() {
			@Override
			public void run() {
				CountDownE countDown = new CountDownE(start);
				countDown.contar();
			}
		};
		Thread hilo = new Thread(cuentaAtrasRunnable);
		hilo.start();
	}
}
