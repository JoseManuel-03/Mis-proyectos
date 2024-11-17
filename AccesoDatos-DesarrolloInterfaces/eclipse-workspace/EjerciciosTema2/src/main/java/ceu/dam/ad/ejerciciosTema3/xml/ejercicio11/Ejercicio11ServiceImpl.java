package ceu.dam.ad.ejerciciosTema3.xml.ejercicio11;

import java.io.File;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.modelo.Libros;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio11ServiceImpl implements Ejercicio11Service {

	@Override
	public void escribirJsonLibros(String pathFile, List<Libro> lista) throws XMLExportException {
		JsonMapper JsonMapper = new JsonMapper();
		File jsonFile = new File(pathFile);
		try {
			Libros libros = new Libros();
			libros.setLibros(lista);
			JsonMapper.writeValue(jsonFile, libros);
		} catch (Exception e) {
			throw new XMLExportException("Error", e);
		}

	}

	@Override
	public List<Libro> leerJsonLibros(String pathFile) throws XMLExportException {
		JsonMapper JsonMapper = new JsonMapper();
		File jsonFile = new File(pathFile);
		try {
			Libro[] libros = JsonMapper.readValue(jsonFile, Libro[].class);
			return Arrays.asList(libros);
		} catch (IOException e) {
			throw new XMLExportException("Error", e);
		}
	}

	@Override
	public void escribirYamlLibros(String pathFile, List<Libro> lista) throws XMLExportException {
		YAMLMapper YAMLMapper = new YAMLMapper();
		File YAMLfile = new File(pathFile);
		try {
			Libros libros = new Libros();
			libros.setLibros(lista);
			YAMLMapper.writeValue(YAMLfile, libros);
		} catch (IOException e) {
			throw new XMLExportException("Error", e);
		}

	}

	@Override
	public List<Libro> leerYamlLibros(String pathFile) throws XMLExportException {
		YAMLMapper YAMLMapper = new YAMLMapper();
		File jsonFile = new File(pathFile);
		try {
			Libros libros = YAMLMapper.readValue(jsonFile, Libros.class);
			return libros.getLibros();
		} catch (IOException e) {
			throw new XMLExportException("Error", e);
		}

	}

}
