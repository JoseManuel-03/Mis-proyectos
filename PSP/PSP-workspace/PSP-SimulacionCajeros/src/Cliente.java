
public class Cliente implements Runnable{

	private CuentaBancaria cuenta;
	private String nombreCliente;
	private final static int milis = 1000;
	
	
	public Cliente(CuentaBancaria cuenta, String nombreCliente) {
		this.cuenta = cuenta;
		this.nombreCliente = nombreCliente;
	}
	
	private void arranca() {
		
		for(int i = 0; i >= 0 ;i++) {
			System.out.println(nombreCliente + i);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void run() {
		arranca();
		
	}
	
	
	
	

}
