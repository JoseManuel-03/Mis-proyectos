package countDown;

public class LCountDown {
	
	public void lanzadora(){
		Runnable cuentaAtrasRunable = new Runnable() {
			
			@Override
			public void run() {
				CountDown countDown = new CountDown(10);
				countDown.cuentaAtras();
				
			}
		};
		
		Thread hilo = new Thread(cuentaAtrasRunable);
		hilo.start();
	}

}
