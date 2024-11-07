package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09;

import java.util.List;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public interface Ejercicio09Service {

	public List<Largometraje> importXML(String pathFile) throws XMLImportException;

}