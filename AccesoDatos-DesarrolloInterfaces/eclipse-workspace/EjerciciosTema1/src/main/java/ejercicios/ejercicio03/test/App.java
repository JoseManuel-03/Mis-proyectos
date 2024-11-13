package ejercicios.ejercicio03.test;

import java.util.List;
import java.util.Map;

import ejercicios.ejercicio03.modelo.Pago;
import ejercicios.ejercicio03.service.PagosException;
import ejercicios.ejercicio03.service.PagosService;

public class App {

	public static void main(String[] args) {
		PagosService service = new PagosService();
		try {
			Map<String, List<Pago>> clientesPagos = service.consultarPagosClientes();
			List<Pago> pagos = clientesPagos.get("MARILYN.ROSS@sakilacustomer.org");
			for (Pago pago : pagos) {
				System.out.println(pago);
			}
		
		} catch (PagosException e) {
			e.printStackTrace();
		}
	}

}
