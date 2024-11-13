package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.app;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.Ejercicio10ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio10ServiceImpl.class);

	public static void main(String[] args) {

		Ejercicio10ServiceImpl service = new Ejercicio10ServiceImpl();
		List<Libro> lista = new ArrayList<Libro>();
		log.info("Creando una lista aleatoriamente");
		lista = Libro.createRandomList(3);
		log.info("Conectando con el servicio");
		try {
			service.escribirXMLLibros(
					"c:/Users/jordonez5404/Desktop/mis proyectos new/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/Ejercicio18libros.xml",lista);
		} catch (XMLExportException e) {
			log.error("Error en el exportar del xml", e);
		}

	}


}
