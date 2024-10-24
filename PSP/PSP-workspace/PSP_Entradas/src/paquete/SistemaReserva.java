package paquete;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class SistemaReserva {
	// Mapa concurrente para manejar las entradas disponibles para cada evento
	private ConcurrentHashMap<String, Evento> eventos = new ConcurrentHashMap<>();

	// Agregar un evento al sistema
	public void agregarEvento(String nombre, int entradasDisponibles) {
		eventos.put(nombre, new Evento(nombre, entradasDisponibles));
	}

	// Método para intentar reservar entradas
	public boolean reservar(String nombreEvento, int cantidad) {
		Evento evento = eventos.get(nombreEvento);
		if (evento != null) { 
			return evento.reservarEntradas(cantidad);
		}
		return false;
	}

	// Obtener el número de entradas restantes para un evento
	public int entradasRestantes(String nombreEvento) {
		Evento evento = eventos.get(nombreEvento);
		return evento != null ? evento.getEntradasDisponibles() : 0;
	}
}