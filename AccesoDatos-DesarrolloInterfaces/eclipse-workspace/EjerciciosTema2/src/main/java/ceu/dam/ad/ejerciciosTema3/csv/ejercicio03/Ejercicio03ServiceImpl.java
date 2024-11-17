package ceu.dam.ad.ejerciciosTema3.csv.ejercicio03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejercicio03ServiceImpl implements Ejercicio03Service {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio03ServiceImpl.class);

	@Override
	public void convertirCsv(String ficheroEntrada, String ficheroSalida) {
		try {
			log.info("Convirtiendo CSV " + ficheroEntrada + " >>> " + ficheroSalida);
			File fileIn = new File(ficheroEntrada);
			File fileOut = new File(ficheroSalida);
			Scanner scanner = new Scanner(fileIn);
			FileWriter writer = new FileWriter(fileOut);
			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				linea = linea.replaceAll(";", ",");
				writer.write(linea + "\n");
			}
			log.info("Conversión completada");
			scanner.close();
			writer.close();

		} catch (IOException e) {
			log.error("Error tratando ficheros", e);
		}

	}

}