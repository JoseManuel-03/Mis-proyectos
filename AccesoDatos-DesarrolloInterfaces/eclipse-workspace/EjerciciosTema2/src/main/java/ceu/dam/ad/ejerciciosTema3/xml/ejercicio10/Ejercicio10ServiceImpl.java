package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libros;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio10ServiceImpl implements Ejercicio10Service {

	@Override
	public void escribirXMLLibros(String pathFile, List<Libro> lista) throws XMLExportException {
		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(pathFile);
		try {
			Libros libros = new Libros();
			libros.setLibros(lista);
			xmlMapper.writeValue(xmlFile, libros);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Libro> leerXMLLibros(String pathFile) throws XMLExportException {
		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(pathFile);
		try {
			Libros libros = xmlMapper.readValue(xmlFile, Libros.class);
			return libros.getLibros();
		} catch (IOException e) {
			throw new XMLExportException("Error, e");
		}
	}

}
