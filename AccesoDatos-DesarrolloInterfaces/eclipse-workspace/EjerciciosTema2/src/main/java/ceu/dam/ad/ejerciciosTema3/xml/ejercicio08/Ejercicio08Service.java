package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public interface Ejercicio08Service {

	public List<Libro> importXML(String pathFile) throws XMLImportException;

}