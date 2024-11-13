package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.app;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.Ejercicio08ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio08ServiceImpl.class);

	public static void main(String[] args) {
		Ejercicio08ServiceImpl service = new Ejercicio08ServiceImpl();
		List<Libro> lista = new ArrayList<Libro>();

		try {
			lista = service.importXML(
					"C:/Users/jordonez5404/Downloads/xmlLibros (7).xml");
			
			for (Libro libro : lista) {
				System.out.println(libro);
			}

		} catch (Exception e) {
			log.error("Error en el importar del xml", e);
		}
	}

} 
