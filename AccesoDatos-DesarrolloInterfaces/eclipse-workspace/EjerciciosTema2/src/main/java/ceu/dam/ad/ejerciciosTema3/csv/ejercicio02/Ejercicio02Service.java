package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;

public interface Ejercicio02Service {

	public void importarUsuarioCSV(String nombreFichero) throws CsvException;

}