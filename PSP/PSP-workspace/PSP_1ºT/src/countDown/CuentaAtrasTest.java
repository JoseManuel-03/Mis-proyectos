package countDown;

public class CuentaAtrasTest {

	public static void main(String[] args) {
		CountDown cd = new CountDown(10);
	//	cd.cuentaAtras();
		
		TCountDown tcd = new TCountDown(cd);
	//	tcd.start();
		
		RCountDown rcd = new RCountDown(cd);
		Thread rHilo = new Thread(rcd);
	//	rHilo.start();
		
		LCountDown lcd = new LCountDown();
		lcd.lanzadora();
		
	}

}
