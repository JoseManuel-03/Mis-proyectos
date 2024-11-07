package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public interface Ejercicio07Service {

	public List<Largometraje> importarXML(String fichero) throws XMLImportException;

}