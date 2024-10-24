
public class Emisor {

	private String nombre;
	private char caracter;
	private Integer tiempoSegundos;

	public Emisor(String nombre, char caracter, Integer tiempoSegundos) {
		super();
		this.nombre = nombre;
		this.caracter = caracter;
		this.tiempoSegundos = tiempoSegundos;
	}

	public void emitir() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";

		long milisFinaL = System.currentTimeMillis() + tiempoSegundos * 1000;
		long milisParaProximaEmision = System.currentTimeMillis() + 300;

		System.out.print(ANSI_GREEN+caracter+ANSI_RESET);
		
		
		while (System.currentTimeMillis() < milisFinaL) {
			if (System.currentTimeMillis() > milisParaProximaEmision) {
				System.out.print(caracter);
				milisParaProximaEmision = System.currentTimeMillis() + 300;
			}
		}
		System.out.print(ANSI_RED+caracter+ANSI_RESET);
	}

	public static void main(String[] args) {
		Emisor emisor = new Emisor("", '*', 3);
		emisor.emitir();

	}

}
