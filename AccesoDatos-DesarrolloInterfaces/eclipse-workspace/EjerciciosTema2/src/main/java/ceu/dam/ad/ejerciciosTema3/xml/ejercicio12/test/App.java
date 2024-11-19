package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.test;


import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12ImplDom;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12ImplJackson;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12ImplSax;

public class App {

	public static void main(String[] args) {
		Ejercicio12ImplDom servicesDom = new Ejercicio12ImplDom();
		Ejercicio12ImplSax servicesSax = new Ejercicio12ImplSax();
		Ejercicio12ImplJackson servicesJack = new Ejercicio12ImplJackson();
		Catalogo catalogo = new Catalogo();
		catalogo = Catalogo.createRandomObject(3);

		try {
			//services.exportXML(catalogo,"C:/Users/jmcor/OneDrive/Escritorio/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/Ejercicio12DOM.xml");
			catalogo = servicesDom.importXML("C:/Users/jordonez5404/Desktop/mis proyectos new/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/Ejercicio12DOM.xml");
			//servicesSax.importXML("C:/Users/jmcor/Downloads/catalogo.xml");
			//servicesJack.importXML("C:/Users/jmcor/Downloads/catalogo.xml");
			//servicesJack.exportXML(catalogo, "C:/Users/jmcor/OneDrive/Escritorio/Mis-proyectos/AccesoDatos-DesarrolloInterfaces/Ejercicio12Jackson.xml");
			System.out.println(catalogo);

		} catch (CatalogoXMLException e) {
			e.printStackTrace();
		}

	}

}
