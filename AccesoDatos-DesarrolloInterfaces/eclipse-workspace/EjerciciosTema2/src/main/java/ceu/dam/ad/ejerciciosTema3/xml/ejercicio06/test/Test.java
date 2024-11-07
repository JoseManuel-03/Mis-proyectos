package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Ejercicio06ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio06ServiceImpl.class);

	public static void main(String[] args) {
		Ejercicio06ServiceImpl service = new Ejercicio06ServiceImpl();
		List<Largometraje> lista = new ArrayList<Largometraje>();
		log.info("Creando una lista aleatoriamente");
		lista = Largometraje.createRandomList(3);
		log.info("Conectando con el servicio");
		try {
			service.exportarXML(lista,
					"c:/Users/jordonez5404/Desktop/mis proyectos new/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/eclipse-workspace/EjerciciosTema2/Ejercicio06Peliculas.xml");
		} catch (XMLExportException e) {
			log.error("Error en el exportar del xml", e);
		}

	}

}
