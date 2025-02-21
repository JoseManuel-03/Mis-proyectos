package ceu.dam.javafx.examen.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ceu.dam.javafx.examen.model.Coche;
import ceu.dam.javafx.examen.model.Reparacion;
import javafx.scene.paint.Color;

public class ExamenService{

	/** Método que nos permite identificar un coche a partir de su matrícula, marca y color. 
	 * Debemos llamarlo desde el login
	 * Devuelve un coche con todos sus datos completos.
	 * 
	 * Si el coche no existe, lanza NotFoundException con el mensaje indicativo.
	 * 
	 * @param String matricula, String marca, Color color
	 * @return
	 * @throws NotFoundException
	 */
	public Coche identificarCoche(String matricula, String marca, Color color) throws NotFoundException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}		
		if (matricula == null || marca == null || color == null) {
			throw new NotFoundException("No existe el coche consultado");
		}
		if ("1".equals(matricula)) {
			Coche coche = new Coche();
			coche.setMatricula(matricula);
			coche.setMarca(marca);
			coche.setColor(color);
			coche.setAño("2012");
			return coche;
		}
		if (matricula.length() < 2 ) {
			throw new NotFoundException("El coche consultado está inactivo");
		}
		if (matricula.length() < 4 ) {
			throw new NotFoundException("La matrícula que intenta consultar está bloqueada");
		}
		throw new NotFoundException("No existe el coche consultado");
	}
	
	
	/** Método que devuelve lista de marcas disponibles en el sistema.
	 * 
	 * @return
	 */
	public List<String> consultarMarcas(){
		return new ArrayList<>(bbdd.keySet()); 
	}
	
	
	/** Método que devuelve todas las reparaciones registradas en el sistema
	 * para el coche de la matrícula indicada. 
	 * Si no hay ninguna, se devuelve una lista vacía
	 * @param matricula
	 * @return
	 */
	public List<Reparacion> consultarReparaciones(String matricula) {
        List<Reparacion> lista = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        LocalDate fechaFija = LocalDate.now();

        lista.addAll(consultarReparaciones(fechaFija, "1"));
        lista.addAll(consultarReparaciones(hoy.plusDays(1), "1"));
        lista.addAll(consultarReparaciones(hoy.plusDays(2), "1"));

        return lista;
	}	
	
	/** Método que devuelve todas las reparaciones registradas en el sistema
	 * para el coche de la matrícula y la fecha que se indica.
	 * Si no hay ninguna, se devuelve una lista vacía
	 * @param matricula
	 * @return
	 */
	public List<Reparacion> consultarReparaciones(LocalDate fecha, String matricula) {
		List<Reparacion> lista = new ArrayList<>();
		if (!"1".equals(matricula) || fecha==null) {
			return lista;
		}
		if (fecha.isAfter(LocalDate.now().plusDays(2)) || fecha.isBefore(LocalDate.now())) {
			return lista;
		}
        Random random = new Random();
        String[] operarios = {"Juan", "Pedro", "Maria", "Luis", "Ana", "Carlos", "Sofia", "Elena", "Jose", "Miguel"};

        for (int i = 0; i < 10; i++) {
            String operario = operarios[random.nextInt(operarios.length)];
            BigDecimal presupuesto = BigDecimal.valueOf(100 + (5000 - 100) * random.nextDouble()).setScale(2, BigDecimal.ROUND_HALF_UP);
            lista.add(new Reparacion("1", fecha, operario, presupuesto));
        }

        return lista;
    }
	
	
	
	
	
	
	
	
	// Ignorar este código...
	private static Map<String, List<Coche>> bbdd = new HashMap<String, List<Coche>>();
	private static List<Coche> seat = new ArrayList<Coche>();
	private static List<Coche> renault = new ArrayList<Coche>();
	private static List<Coche> bmw = new ArrayList<Coche>();
	private static List<Coche> toyota = new ArrayList<Coche>();
	static {
		toyota.add(new Coche("Toyota", "Auris", "2010", "1521FFD", 8532));
		toyota.add(new Coche("Toyota", "Auris", "2013", "4862DDD", 7896));
		toyota.add(new Coche("Toyota", "Rav4", "2016", "4862BRT", 15000));
		toyota.add(new Coche("Toyota", "Corolla", "2020", "8761DQT", 16100));
		toyota.add(new Coche("Toyota", "Yaris", "2012", "9661JKK", 4350));
		toyota.add(new Coche("Toyota", "Rav4", "2019", "4134NBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2005", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "León", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "León", "2020", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Toledo", "2005", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "Toledo", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "Toledo", "2020", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		renault.add(new Coche("Renault", "Laguna", "2017", "5562CRT", 3245));
		renault.add(new Coche("Renault", "Clío", "2020", "8551CQC", 11500));
		renault.add(new Coche("Renault", "Megane", "2008", "1555FPD", 12000));
		renault.add(new Coche("Renault", "Megane", "2003", "4662RWD", 10012));
		renault.add(new Coche("Renault", "Megane", "2010", "9001VVF", 6588));
		renault.add(new Coche("Renault", "Clío", "2009", "0034BWW", 1500));
		bbdd.put("TOYOTA", toyota);
		bbdd.put("SEAT", seat);
		bbdd.put("RENAULT", renault);
		bbdd.put("BMW", bmw);
		
	}
	
	

	
}
