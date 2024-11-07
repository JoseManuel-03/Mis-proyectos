package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04;

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

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class Ejercicio04ServiceImpl implements Ejercicio04Service {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio04ServiceImpl.class);

	@Override
	public void exportXML(List<Libro> libros, String pathFile) throws XMLExportException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			log.info("Creando el documento xml");
			Document xml = builder.newDocument();
			Element librosTag = xml.createElement("libros");
			xml.appendChild(librosTag);

			for (Libro libro : libros) {
				log.debug("Se añade hijo libro");
				Element libroTag = xml.createElement("libro");
				librosTag.appendChild(libroTag);
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				log.debug("Se añade hijo titulo");
				Element tituloTag = xml.createElement("titulo");
				librosTag.setAttribute("titulo", libro.getTitulo().toString());
				libroTag.appendChild(tituloTag);
				log.debug("Se añade hijo autores");
				Element autoresTag = xml.createElement("autores");
				libroTag.setAttribute("autores", libro.getAutores().toString());
				libroTag.appendChild(autoresTag);
				for (String autor : libro.getAutores()) {
					log.debug("Se añade hijo autor");
					Element autorTag = xml.createElement("autor");
					autorTag.setTextContent(autor);
					autoresTag.appendChild(autorTag);

				}
				log.debug("Se añade hijo ediciones");
				Element edicionesTag = xml.createElement("ediciones");
				libroTag.appendChild(edicionesTag);

				for (Edicion edicion : libro.getEdiciones()) {
					log.debug("Se añade hijo edicion");
					Element edicionTag = xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);

					log.debug("Se añade hijo año");
					Element añoTag = xml.createElement("año");
					añoTag.setAttribute("año", edicion.getAño().toString());
					edicionTag.appendChild(añoTag);

					log.debug("Se añade hijo editorial");
					Element editorialTag = xml.createElement("editorial");
					editorialTag.setAttribute("editorial", edicion.getEditorial().toString());
					edicionTag.appendChild(editorialTag);
					log.info("Fichero creado");
				}

			}
			DOMSource source = new DOMSource(xml);
			File fichero = new File(pathFile);
			StreamResult result = new StreamResult(fichero);
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			transformer.transform(source, result);

		} catch (Exception e) {
			log.error("Error en la resolución del XML", e);
		}

	}

}
