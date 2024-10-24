package psp;

public class ContadorDeCuentaAtras extends Thread{
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


	public ContadorDeCuentaAtras(int valorMaximo, String nombre) {
		this.valorMaximo = valorMaximo;
		this.nombre = nombre;
	}



	public static void main(String[] args) {
		
		
		ContadorDeCuentaAtras c1 = new ContadorDeCuentaAtras(10, "C-1");
		ContadorDeCuentaAtras c2 = new ContadorDeCuentaAtras(5, "C-2");
		c1.start();
		c2.start();
	}
}
