package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.Ejercicio05ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio05ServiceImpl.class);

	public static void main(String[] args) {
		Ejercicio05ServiceImpl service = new Ejercicio05ServiceImpl();
		List<Libro> lista = new ArrayList<Libro>();
		log.info("Conectando con el servicio");

		try {
			lista = service.importXML("C:/Users/jordonez5404/Downloads/xmlLibros (3).xml");
			for (Libro libro : lista) {
				System.out.println(libro);
			}
		} catch (XMLImportException e) {
			log.error("Error en el importar del xml", e);
		}

	}

}
