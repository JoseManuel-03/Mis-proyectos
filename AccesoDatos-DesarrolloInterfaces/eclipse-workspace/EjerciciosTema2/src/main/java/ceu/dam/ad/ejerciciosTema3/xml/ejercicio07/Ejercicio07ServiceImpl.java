package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Persona;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio07ServiceImpl implements Ejercicio07Service {

	@Override
	public List<Largometraje> importarXML(String fichero) throws XMLImportException {
		List<Largometraje> peliculas = new ArrayList<Largometraje>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;

			builder = factory.newDocumentBuilder();
			File pathFile = new File(fichero);
			Document xml = builder.parse(pathFile);

			Element peliculasTag = xml.getDocumentElement();

			NodeList peliculaList = peliculasTag.getElementsByTagName("pelicula");
			for (int i = 0; i < peliculaList.getLength(); i++) {

				Element peliculaTag = (Element) peliculaList.item(0);
				Largometraje pelicula = new Largometraje();
				peliculas.add(pelicula);

				Element tituloTag = (Element) peliculaTag.getElementsByTagName("titulo");
				pelicula.setTitulo(tituloTag.getTextContent());

				Element duracionTag = (Element) peliculasTag.getElementsByTagName("duracion");
				pelicula.setTitulo(duracionTag.getTextContent());

				Element añoTag = (Element) peliculasTag.getElementsByTagName("año");
				pelicula.setTitulo(añoTag.getTextContent());

				Element artistasTag = (Element) peliculasTag.getElementsByTagName("artistas").item(0);
				NodeList artistasList = artistasTag.getElementsByTagName("artistas");
				pelicula.setActores(null);
				for (int j = 0; j < artistasList.getLength(); j++) {

					Element artistaTag = (Element) artistasList.item(j);
					Persona persona = new Persona();

					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre");
					persona.setNombre(nombreTag.getTextContent());

					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad");
					persona.setNacionalidad(nacionalidadTag.getTextContent());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return peliculas;
	}

}
