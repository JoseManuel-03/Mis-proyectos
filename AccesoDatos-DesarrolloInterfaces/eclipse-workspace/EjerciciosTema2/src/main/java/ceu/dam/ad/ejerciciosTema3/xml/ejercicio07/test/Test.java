package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.Ejercicio07ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio07ServiceImpl.class);

	public static void main(String[] args) {
		Ejercicio07ServiceImpl service = new Ejercicio07ServiceImpl();
		List<Largometraje> lista = new ArrayList<Largometraje>();
		log.info("Conectando con el servicio");

		try {
			lista = service.importarXML("C:/Users/jmcor/Downloads/xmlPeliculas");
			for (Largometraje largometraje : lista) {
				System.out.println(largometraje);
			}
		} catch (XMLImportException e) {
			log.error("Error en el importar del xml", e);
		}

	}

}
