
public class BancoSimulacionApp {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(1000);
		Cliente cliente1 = new Cliente(cuenta, "pepe");
		
		new Thread(cliente1).start();

	}

}
