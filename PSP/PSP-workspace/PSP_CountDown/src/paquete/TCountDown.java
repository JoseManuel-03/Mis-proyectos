package paquete;

public class TCountDown extends Thread {
	private CountDown countDown;

	public TCountDown(CountDown countDown) {
		super();
		this.countDown = countDown;
	}
	
	public void run() {
		countDown.cuentaAtras();
	}
	
	

}
