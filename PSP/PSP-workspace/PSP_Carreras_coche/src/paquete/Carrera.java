package paquete;

public class Carrera {

	private Integer kmTotales;
	private String[] podio;
	private Integer personasEnPodio;

	public Carrera(Integer kmTotales) {
		this.kmTotales = kmTotales;
		podio = new String[10_000];
		personasEnPodio = 0;
	}

	public Integer getKmTotales() {
		return kmTotales;
	}

	public synchronized void subirAlPodio(String nombreCoche) {
		podio[personasEnPodio] = nombreCoche;
		personasEnPodio++;
	}

	public void imprimirPodio() {
		System.out.println("Podio de la carrera: ");
		for (int i = 0; i < podio.length; i++) {
			System.out.printf("\tLugar %d -> %s%n", i + 1, podio[i]);
		}
	}
}