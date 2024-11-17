package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;

public class Ejercicio12ImplJackson implements Ejercicio12Service {

	@Override
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException {

		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(pathFile);
		try {
			xmlMapper.writeValue(xmlFile, catalogo);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {

		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(pathFile);
		try {
			Catalogo catalogo = xmlMapper.readValue(xmlFile, Catalogo.class);
			return catalogo;
		} catch (IOException e) {
			throw new CatalogoXMLException("Error", e);
		}

	}

}
