package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

public class Ejercicio05ServiceImpl implements Ejercicio05Service {

	@Override
	public List<Libro> importXML(String pathFile) throws XMLImportException {
		List<Libro> libros = new ArrayList<>();
		List<Edicion> ediciones = new ArrayList<>();
		List<String> autores = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File fichero = new File(pathFile);
			Document xml = builder.parse(fichero);

			Element librosTag = xml.getDocumentElement();

			NodeList libroList = librosTag.getElementsByTagName("libro");
			for (int i = 0; i < libroList.getLength(); i++) {
				Element libroTag = (Element) libroList.item(i);
				Libro libro = new Libro();
				libros.add(libro);
				Integer isbn = Integer.parseInt(libroTag.getAttribute("isbn"));
				libro.setIsbn(isbn);

				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				libro.setTitulo(tituloTag.getTextContent());

				NodeList autoresList = libroTag.getElementsByTagName("autores");
				libro.setAutores(autores);
				for (int j = 0; j < autoresList.getLength(); j++) {
					Element autorTag = (Element) autoresList.item(j);
					autores.add(autorTag.getTextContent());

				}
				Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList edicionesList = edicionesTag.getElementsByTagName("ediciones");
				libro.setEdiciones(ediciones);
				for (int k = 0; k < edicionesList.getLength(); k++) {

					Element edicionTag = (Element) edicionesList.item(k);
					Edicion edicion = new Edicion();
					ediciones.add(edicion);
					Integer año = Integer.parseInt(edicionTag.getAttribute("año"));
					edicion.setAño(año);

					Element editorialTag = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					edicion.setEditorial(editorialTag.getTextContent());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
	}

}
