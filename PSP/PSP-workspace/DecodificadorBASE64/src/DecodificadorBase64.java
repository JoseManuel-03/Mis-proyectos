import java.util.Base64;
import java.util.Scanner;

public class DecodificadorBase64 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Dime texto a codificar en Base 64: ");

		String textoSinCodificar = scanner.nextLine();
		
		byte[] decodedBytes = Base64.getDecoder().decode(textoSinCodificar);
		
		String decodedString = new String(decodedBytes);
		
		System.out.println("El resultado codificado es: " + decodedString);

		scanner.close();
	}

}
