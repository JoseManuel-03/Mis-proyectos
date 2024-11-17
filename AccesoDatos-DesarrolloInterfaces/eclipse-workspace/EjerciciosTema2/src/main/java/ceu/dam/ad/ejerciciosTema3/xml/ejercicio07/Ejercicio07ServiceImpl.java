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
				Element peliculaTag = (Element) peliculaList.item(i);
				Largometraje pelicula = new Largometraje();
				pelicula.setActores(new ArrayList<>());
				peliculas.add(pelicula);
				Element tituloTag = (Element) peliculaTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();
				pelicula.setTitulo(titulo);
				Element duracionTag = (Element) peliculaTag.getElementsByTagName("duracion").item(0);
				String duracion = duracionTag.getTextContent();
				pelicula.setDuracion(Integer.parseInt(duracion));
				Element añoTag = (Element) peliculaTag.getElementsByTagName("año").item(0);
				String año = añoTag.getTextContent();
				pelicula.setAño(Integer.parseInt(año));
				Element artistasTag = (Element) peliculaTag.getElementsByTagName("artistas").item(0);
				NodeList artistaTagList = artistasTag.getElementsByTagName("artista");
				for (int j = 0; j < artistaTagList.getLength(); j++) {
					Element artistaTag = (Element) artistaTagList.item(j);
					Persona persona = new Persona();
					String tipo = artistaTag.getAttribute("tipo");
					if (tipo.equals(Persona.DIRECCION)) {
						pelicula.setDireccion(persona);
					} else if (tipo.equals(Persona.PRODUCCION)) {
						pelicula.setProduccion(persona);
					} else {
						pelicula.getActores().add(persona);
					}
					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					String nombre = nombreTag.getTextContent();
					persona.setNombre(nombre);

					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					String nacionalidad = nacionalidadTag.getTextContent();
					persona.setNacionalidad(nacionalidad);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return peliculas;
	}

}
