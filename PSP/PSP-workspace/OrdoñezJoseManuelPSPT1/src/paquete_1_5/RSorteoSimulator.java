package paquete_1_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RSorteoSimulator implements Runnable{
	private String nombreSorteo;
	private Integer numeroInicial;
	private Integer numeroFinal;
	private Integer bolasExtraer;
	private List<Integer> lista;

	public RSorteoSimulator(String nombreSorteo, Integer numeroInicial, Integer numeroFinal, Integer bolasExtraer) {
		super();
		this.nombreSorteo = nombreSorteo;
		this.numeroInicial = numeroInicial;
		this.numeroFinal = numeroFinal;
		this.bolasExtraer = bolasExtraer;
		lista = new ArrayList<Integer>();
	}

	public void generaUnaCombinaciónGanadora(long milis) {
		while (milis >= 0) {
			milis--;
			try {

				Integer arrayCaracteres[] = new Integer[numeroFinal];
				for (int i = 0; i < arrayCaracteres.length; i++) {
					arrayCaracteres[i] = i;
				}
				lista = Arrays.asList(arrayCaracteres);
				Collections.shuffle(lista);
				lista.toArray(arrayCaracteres);
		//		lista.sort(null);                       Nota: Sé que es con el sort pero no he conseguido hacerlo

				for (int i = 0; i < bolasExtraer; i++) {
					System.out.println(arrayCaracteres[i]);
				}

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		generaUnaCombinaciónGanadora(2000);
		
	}

	@Override
	public String toString() {
		return nombreSorteo + "desde la bola " + numeroInicial + "a la " + numeroFinal + "donde se extraen"
				+ bolasExtraer + "bolas";
	}


}
