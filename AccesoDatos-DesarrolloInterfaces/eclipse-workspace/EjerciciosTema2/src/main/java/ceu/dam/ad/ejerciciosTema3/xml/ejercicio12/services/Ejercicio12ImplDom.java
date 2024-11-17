package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Articulo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Categoria;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Modelo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Pvp;

public class Ejercicio12ImplDom implements Ejercicio12Service {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio12ImplDom.class);

	@Override
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {

			builder = factory.newDocumentBuilder();
			log.info("Creando el documento xml");
			Document xml = builder.newDocument();
			Element catalogoTag = xml.createElement("catálogo");
			xml.appendChild(catalogoTag);

			Element tamañoTag = xml.createElement("tamaño");
			catalogoTag.setAttribute("tamaño", catalogo.getTamaño().toString());//ATRIBUTO DENTRO DE TAG

			Element articulosTag = xml.createElement("articulos");
			catalogoTag.appendChild(articulosTag);

			for (Articulo articulo : catalogo.getArticulos()) {

				Element articuloTag = xml.createElement("articulo");
				articulosTag.appendChild(articuloTag);

				Element descripcionTag = xml.createElement("descripcion");
				articuloTag.appendChild(descripcionTag);
				descripcionTag.setTextContent(articulo.getDescripcion());

				Element identificadorTag = xml.createElement("identificador");
				articuloTag.appendChild(identificadorTag);
				identificadorTag.setTextContent(articulo.getSku());

				Element precioTag = xml.createElement("precio");
				articuloTag.appendChild(precioTag);
				precioTag.setTextContent(articulo.getPvp().getPrecio().toString());

				Element modelosDisponiblesTag = xml.createElement("modelosDisponibles");
				articuloTag.appendChild(modelosDisponiblesTag);

				for (Modelo modelos : articulo.getModelos()) {

					Element modeloTag = xml.createElement("modelo");
					modelosDisponiblesTag.appendChild(modeloTag);

					Element tallaTag = xml.createElement("talla");
					modeloTag.appendChild(tallaTag);
					tallaTag.setTextContent(modelos.getTalla());

					Element colorTag = xml.createElement("color");
					modeloTag.appendChild(colorTag);
					colorTag.setTextContent(modelos.getColor());

					Element codigosBarrasTag = xml.createElement("codigosBarra");
					modeloTag.appendChild(codigosBarrasTag);

					for (String codigos : modelos.getCodigosBarra()) {

						Element codigoTag = xml.createElement("codigo");
						codigosBarrasTag.appendChild(codigoTag);
						codigoTag.setTextContent(codigos);

					}
				}
			}

			DOMSource source = new DOMSource(xml);
			File path = new File(pathFile);
			StreamResult result = new StreamResult(path);
			TransformerFactory transformerFact = TransformerFactory.newInstance();
			Transformer transformer = transformerFact.newTransformer();
			transformer.transform(source, result);

		} catch (Exception e) {
			log.error("Error en la resolución del XML", e);
		}
	}

	@Override
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {
		Catalogo catalogo = new Catalogo();
		Articulo articulo = new Articulo();
		Modelo modelo = new Modelo();
		Pvp pvp = new Pvp();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			File fichero = new File(pathFile);
			Document xml = builder.parse(fichero);

			Element catalogoTag = xml.getDocumentElement();
			List<Catalogo> listaCatalogo = new ArrayList<Catalogo>();

			Integer tamaño = Integer.parseInt(catalogoTag.getAttribute("tamaño"));
			catalogo.setTamaño(tamaño);

			listaCatalogo.add(catalogo);
			Element articulosTag = (Element) catalogoTag.getElementsByTagName("articulos").item(0);

			NodeList articuloList = articulosTag.getElementsByTagName("articulo");
			for (int i = 0; i < articuloList.getLength(); i++) {
				List<Articulo> articulos = new ArrayList<Articulo>();
				articulos.add(articulo);
				Element articuloTag = (Element) articuloList.item(i);

				Element descripcionTag = (Element) articuloTag.getElementsByTagName("descripcion").item(0);
				articulo.setDescripcion(descripcionTag.getTextContent());

				Element identificadorTag = (Element) articuloTag.getElementsByTagName("identificador").item(0);
				articulo.setSku(identificadorTag.getTextContent());

				Element precioTag = (Element) articuloTag.getElementsByTagName("precio").item(0);
				
				articulo.getPvp().setPrecio(new BigDecimal(precioTag.getTextContent()));                     /////ERROR AQUI

				Element modelosDisponiblesTag = (Element) articuloTag.getElementsByTagName("modelosDisponibles")
						.item(0);

				NodeList modelosList = modelosDisponiblesTag.getElementsByTagName("modelo");

				for (int j = 0; j < modelosList.getLength(); j++) {
					List<Modelo> modelos = new ArrayList<Modelo>();
					modelos.add(modelo);

					Element modeloTag = (Element) modelosList.item(j);

					Element tallaTag = (Element) modeloTag.getElementsByTagName("talla").item(0);
					modelo.setTalla(tallaTag.getTextContent());

					Element colorTag = (Element) modeloTag.getElementsByTagName("color").item(0);
					modelo.setColor(colorTag.getTextContent());

					Element codigosBarrasTag = (Element) modeloTag.getElementsByTagName("codigosBarra").item(0);
					NodeList codigosBarrasList = codigosBarrasTag.getElementsByTagName("codigo");

					List<String> codigosBarra = new ArrayList<String>();
					for (int k = 0; k < codigosBarrasList.getLength(); k++) {
						Element codigoTag = (Element) codigosBarrasList.item(k);
						codigosBarra.add(codigoTag.getTextContent());

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return catalogo;
	}

}
