package ceu.dam.javafx.practica3.service;

import java.util.ArrayList;
import java.util.List;

import ceu.dam.javafx.practica3.modelo.Animal;

public class AnimalesServices {

	private static List<Animal> animales;
	
	public List<Animal> consultarAnimales(String tipo) throws AnimalesNotFoundException{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tipo != null && tipo.isEmpty()) {
			return animales;
		}
		List<Animal> filtrados = animales.stream().filter(a -> a.getTipo().equalsIgnoreCase(tipo)).toList();
		if (filtrados.isEmpty()) {
			throw new AnimalesNotFoundException("No hay registros en BBDD con el filtro indicado");
		}
		return filtrados;
	}

	
	public void addAnimal(Animal a) {
		animales.add(a);
	}
	
	
	static {
		animales  = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("gato", "blas " + i, + 3+i);
			animales.add(a);
		}
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("perro", "blas " + i, + 3+i);
			animales.add(a);
		}
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("loro", "blas " + i, + 3+i);
			animales.add(a);
		}
	}
	
	
}
