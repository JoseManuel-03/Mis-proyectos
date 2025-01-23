import java.util.Base64;
import java.io.*;

public class CodificadorBase64 {

	public static void main(String[] args) {
		try {
			String fileNameLectura = "C:/Users/jordonez5404/Downloads/hola.txt";

			FileWriter writer = new FileWriter(fileNameLectura);
			writer.write("Este es un texto de ejemplo para codificar en Base64.");
			writer.close();

			BufferedReader reader = new BufferedReader(new FileReader(fileNameLectura));
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
			reader.close();

			byte[] encodeBytes = Base64.getEncoder().encode(content.toString().getBytes());
			String encodeString = new String(encodeBytes);
			

			String fileNameEscribir = "C:/Users/jordonez5404/Downloads/archivo_codificado.txt";
			FileWriter writerCodificado = new FileWriter(fileNameEscribir);
			writerCodificado.write(encodeString);
			writerCodificado.close();

			System.out.println("El contenido codificado se ha guardado en: " + fileNameEscribir);

		} catch (IOException e) {
			System.out.println("Ocurrió un error: " + e.getMessage());
		}
	}
}
