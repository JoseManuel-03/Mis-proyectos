package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Persona;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio06ServiceImpl implements Ejercicio06Service {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio06ServiceImpl.class);

	public void exportarXML(List<Largometraje> peliculas, String fichero) throws XMLExportException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			log.info("Creando el documento xml");
			Document xml = builder.newDocument();
			Element peliculasTag = xml.createElement("peliculas");
			xml.appendChild(peliculasTag);

			for (Largometraje pelicula : peliculas) {
				Element peliculaTag = xml.createElement("pelicula");
				peliculasTag.appendChild(peliculaTag);

				Element tituloTag = xml.createElement("titulo");
				peliculasTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo().toString());

				Element duracionTag = xml.createElement("duracion");
				peliculasTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());

				Element añoTag = xml.createElement("año");
				peliculasTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());

				Element artistasTag = xml.createElement("artistas");
				peliculasTag.appendChild(artistasTag);

				getArtistas(xml, pelicula.getDireccion(), artistasTag, Persona.DIRECCION);
				getArtistas(xml, pelicula.getProduccion(), artistasTag, Persona.PRODUCCION);

				for (Persona artista : pelicula.getActores()) {

					getArtistas(xml, artista, artistasTag, Persona.INTERPRETACION);
				}
			}

			DOMSource source = new DOMSource(xml);
			File path = new File(fichero);
			StreamResult result = new StreamResult(path);
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			transformer.transform(source, result);

		} catch (Exception e) {
			log.error("Error en la resolución del XML", e);
		}
	}

	private void getArtistas(Document xml, Persona actor, Element artistasTag, String tipo) {

		Element artistaTag = xml.createElement("artista");
		artistasTag.appendChild(artistaTag);
		artistaTag.setAttribute("tipo", tipo);

		Element nombreTag = xml.createElement("nombre");
		artistaTag.appendChild(nombreTag);
		nombreTag.setTextContent(actor.getNombre().toString());

		Element nacionalidadTag = xml.createElement("nacionalidad");
		artistaTag.appendChild(nacionalidadTag);
		nacionalidadTag.setTextContent(actor.getNacionalidad().toString());

	}

}
