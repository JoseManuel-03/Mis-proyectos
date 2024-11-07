package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio04ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import jdk.internal.org.jline.utils.Log;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio04ServiceImpl.class);

	public static void main(String[] args) {

		Ejercicio04ServiceImpl service = new Ejercicio04ServiceImpl();
		List<Libro> lista = new ArrayList<Libro>();
		log.info("Creando una lista aleatoriamente");
		lista = Libro.createRandomList(3);
		log.info("Conectando con el servicio");
		try {
			service.exportXML(lista,
					"c:/Users/jordonez5404/Desktop/mis proyectos new/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/Ejercicio04libros.xml");
		} catch (XMLExportException e) {
			log.error("Error en el exportar del xml", e);
		}

	}

}
