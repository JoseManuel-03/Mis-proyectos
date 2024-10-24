
public class DeficionEmisor {
	
	private String nombre;
	private char caracter;
	private int pulsos;
	
	public DeficionEmisor(String nombre, char caracter, int pulsos) {
		super();
		this.nombre = nombre;
		this.caracter = caracter;
		this.pulsos = pulsos;
	}

	public DeficionEmisor(char caracter, int pulsos) {
		super();
		this.caracter = caracter;
		this.pulsos = pulsos;
	}
	
	
	public void emiteUnitariamente() {
		System.out.print(caracter);
	}

}
