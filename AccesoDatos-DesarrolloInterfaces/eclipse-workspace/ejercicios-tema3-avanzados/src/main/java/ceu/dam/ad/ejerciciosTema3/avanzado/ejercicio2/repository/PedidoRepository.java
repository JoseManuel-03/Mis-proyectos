package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository;

import java.util.UUID;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Cliente;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Pedido;
import java.util.List;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.PedidoLinea;
import java.util.Date;




@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
	
	
	List<Pedido> findByCliente(Cliente cliente);
	
	List<Pedido> findByLineas(List<PedidoLinea> lineas);
	
	List<Pedido> findByFecha(Date fecha);
	
	
	
	
	
	

}
