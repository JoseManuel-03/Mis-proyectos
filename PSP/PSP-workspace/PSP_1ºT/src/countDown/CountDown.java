package countDown;

public class CountDown {

	private Integer numeroInicial;
	private static int milis = 500;
	
	public Integer getNumeroInicial() {
		return numeroInicial;
	}
	public void setNumeroInicial(Integer numeroInicial) {
		this.numeroInicial = numeroInicial;
	}
	public static int getMilis() {
		return milis;
	}
	public static void setMilis(int milis) {
		CountDown.milis = milis;
	}
	public CountDown(Integer numeroInicial) {
		super();
		this.numeroInicial = numeroInicial;
	}
	
	public void cuentaAtras() {
		while(numeroInicial>=0) {
			System.out.print(numeroInicial +" ");
			numeroInicial--;
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	

}
