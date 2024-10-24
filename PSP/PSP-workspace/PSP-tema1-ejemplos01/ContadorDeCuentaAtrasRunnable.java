package psp;

public class ContadorDeCuentaAtrasRunnable implements Runnable {
	private int valorMaximo;
	private String nombre;
	private int valor;
	private static int milis = 300;
	
	@Override
	public void run() {
		for(this.valor = valorMaximo; valor >= 0; valor--) {
			System.out.println(toString());
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public String toString() {
		return "ContadorDeCuentaAtras [valorMaximo=" + valorMaximo + ", nombre=" + nombre + ", valor=" + valor + "]";
	}


	public ContadorDeCuentaAtrasRunnable(int valorMaximo, String nombre) {
		this.valorMaximo = valorMaximo;
		this.nombre = nombre;
	}



	public static void main(String[] args) {
		
		
		ContadorDeCuentaAtrasRunnable c1 = new ContadorDeCuentaAtrasRunnable(10, "C-1");
		ContadorDeCuentaAtrasRunnable c2 = new ContadorDeCuentaAtrasRunnable(5, "C-2");
		new Thread(c1).start();
		new Thread(c2).start();
	}
	
	
}
