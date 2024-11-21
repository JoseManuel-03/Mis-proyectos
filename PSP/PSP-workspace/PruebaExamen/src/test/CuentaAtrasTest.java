package test;

import paquete.LCountDown;
import paquete.RCountDownE;
import paquete.TCountDownE;

public class CuentaAtrasTest {
	public static void main(String[] args) {
		// Iniciar cuenta atrás con TCountDown (Hereda Thread)
		TCountDownE tCountDown = new TCountDownE(5);
		tCountDown.start();

		// Iniciar cuenta atrás con RCountDown (Implementa Runnable)
		Thread rHilo = new Thread(new RCountDownE(5));
		rHilo.start();

		// Iniciar cuenta atrás con LCountDown (Clase lanzadora)
		LCountDown lCountDown = new LCountDown();
		lCountDown.lanzarCuentaAtras(5);
	}
}