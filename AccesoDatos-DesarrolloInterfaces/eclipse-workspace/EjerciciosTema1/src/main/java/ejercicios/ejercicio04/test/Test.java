package ejercicios.ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import ejercicios.ejercicio04.modelo.Pedido;
import ejercicios.ejercicio04.modelo.PedidoLinea;
import ejercicios.ejercicio04.service.PedidoException;
import ejercicios.ejercicio04.service.PedidoNotFoundException;
import ejercicios.ejercicio04.service.PedidosService;

public class Test {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2024, 12, 1));
		pedido.setCliente("Lucas Cangrejo");
		pedido.setLineas(new ArrayList<PedidoLinea>());
		
		for (int j = 1; j <= 3; j++) {
			PedidoLinea linea = new PedidoLinea();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineas().add(linea);
		}
		
		PedidosService service = new PedidosService();
		try {
			Long idPedido = service.crearPedido(pedido);
			System.out.println("Pedido registrado con id: " + idPedido);
			
			Pedido consultado = service.consultarPedido(idPedido);
			System.out.println(consultado);
		} catch (PedidoException e) {
			e.printStackTrace();
		} catch (PedidoNotFoundException e) {
			System.out.println(e);
		}
		
		
	}

}
