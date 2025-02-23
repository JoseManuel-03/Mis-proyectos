package ceu.dam.ad.tema3.ejercicios.ejercicio06.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.Pedido;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.PedidoLinea;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.service.PedidoException;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.service.PedidoNotFoundException;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.service.PedidosService;
@Component
public class TestEj6 {
	@Autowired
	private PedidosService pedidosService;
	
	public void test() {
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
		
		try {
			Long idPedido = pedidosService.crearPedido(pedido);
			System.out.println("Pedido registrado con id: " + idPedido);
			
			Pedido consultado = pedidosService.consultarPedido(idPedido);
			System.out.println(consultado);
		} catch (PedidoException e) {
			e.printStackTrace();
		} catch (PedidoNotFoundException e) {
			System.out.println(e);
		}
		
		
	}

}
