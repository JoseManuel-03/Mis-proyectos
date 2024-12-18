package countDown;

public class RCountDown implements 	Runnable{
	
	private CountDown countDown;
	
	

	public RCountDown(CountDown countDown) {
		super();
		this.countDown = countDown;
	}



	@Override
	public void run() {
		countDown.cuentaAtras();
		
	}

}
