package ejemplos.ejemplo1.test;

import java.util.List;

import ejemplos.ejemplo1.modelo.Actor;
import ejemplos.ejemplo1.services.ActorServiceException;
import ejemplos.ejemplo1.services.ActoresService;

public class Test {

	public static void main(String[] args) {
		ActoresService service = new ActoresService();
		try {
			List<Actor> actores= service.buscarActores("AN");
			System.out.println(actores);
			
		} catch (ActorServiceException e) {
			e.printStackTrace();
		}

	}

}
