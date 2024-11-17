package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;

public class Ejercicio12ImplSax implements Ejercicio12Service {

	@Override
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			CatalogoXMLHandler handler = new CatalogoXMLHandler();

			File file = new File(pathFile);
			saxParser.parse(file, handler);
			return handler.getCatalogo();
		} catch (Exception e) {
			throw new CatalogoXMLException();
		}
	}

}
