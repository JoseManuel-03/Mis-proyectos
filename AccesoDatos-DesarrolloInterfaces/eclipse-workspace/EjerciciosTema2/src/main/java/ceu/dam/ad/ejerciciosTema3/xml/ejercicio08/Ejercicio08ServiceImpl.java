package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio08ServiceImpl implements Ejercicio08Service {

	@Override
	public List<Libro> importXML(String pathFile) throws XMLImportException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();

			Ejercicio08ServiceHandler handler = new Ejercicio08ServiceHandler();
			File file = new File(pathFile);
			saxParser.parse(file, handler);

			return handler.getLibros();
		} catch (Exception e) {

			throw new XMLImportException("Error leyendo xml", e);
		}

	}

}
