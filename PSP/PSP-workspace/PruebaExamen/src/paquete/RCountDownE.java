package paquete;

public class RCountDownE implements Runnable {
	private CountDownE countDown;

	public RCountDownE(int start) {
		this.countDown = new CountDownE(start);
	}

	@Override
	public void run() {
		countDown.contar();
	}
}