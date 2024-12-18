package paquete_1_5;

public class Run {

	public static void main(String[] args) {
		SorteoSimulator s1 = new SorteoSimulator("bonoloto española", 1, 49, 6);
		s1.generaUnaCombinaciónGanadora(2000);

		TSorteoSimulator t1 = new TSorteoSimulator("bonoloto italiana", 1, 90, 5);
		t1.generaUnaCombinaciónGanadora(2000);

		RSorteoSimulator r1 = new RSorteoSimulator("bonoloto francesa", 1, 49, 5);
		r1.generaUnaCombinaciónGanadora(2000);

		LSorteoSimulator l1 = new LSorteoSimulator("bonoloto alemana", 1, 49, 6);
		l1.generaUnaCombinaciónGanadora(2000);

	}

}
