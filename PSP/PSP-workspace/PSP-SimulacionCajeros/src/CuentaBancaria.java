import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

	private Integer saldo;
	private List<String> registroTransacciones;

	public CuentaBancaria(Integer saldo) {
		this.saldo = saldo;
		registroTransacciones = new ArrayList<String>();
	}

	public synchronized boolean retirarDinero(Integer cantidad, String nombreCliente) {
		if(saldo<cantidad) {
			return false;
		}
		saldo = saldo-cantidad;
		return true;

	}

	public Integer obtenerSaldo() {
		return saldo;

	}
	
	public void registrarTransaccion(String trasaccion) {
		registroTransacciones.add(trasaccion);
	}
	
	public void imprimirHistorialTransacciones() {
		for (String transaccion : registroTransacciones) {
			System.out.println(transaccion);
		}
	}

}
