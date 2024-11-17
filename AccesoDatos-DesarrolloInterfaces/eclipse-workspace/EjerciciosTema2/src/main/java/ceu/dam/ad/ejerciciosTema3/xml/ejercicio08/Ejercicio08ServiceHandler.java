package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08;

import java.util.ArrayList;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;

public class Ejercicio08ServiceHandler extends DefaultHandler {
	private Boolean openTag;
	private String texto;
	private List<Libro> libros;
	private Libro libro;
	private List<String> autores;
	private List<Edicion> ediciones;
	private Edicion edicion;
	public List<Libro> getLibros() {
		return libros;
	}
	@Override
	public void startDocument() throws SAXException {
		libros = new ArrayList<>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		openTag = true;
		texto = "";
		if (qName.equals("libro")) {
			libro = new Libro();
			Integer isbn = Integer.parseInt(attributes.getValue("isbn"));
			libro.setIsbn(isbn);
			libros.add(libro);
		} else if (qName.equals("autores")) {
			autores = new ArrayList<>();
			libro.setAutores(autores);
		} else if (qName.equals("ediciones")) {
			ediciones = new ArrayList<>();
			libro.setEdiciones(ediciones);
		} else if (qName.equals("edicion")) {
			edicion = new Edicion();
			libro.getEdiciones().add(edicion);
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		openTag = false;
		if (qName.equals("titulo")) {
			libro.setTitulo(texto);
		} else if (qName.equals("autor")) {
			libro.getAutores().add(texto);
		} else if (qName.equals("año")) {
			edicion.setAño(Integer.parseInt(texto));	
		} else if (qName.equals("editorial")) {
			edicion.setEditorial(texto);
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

}
