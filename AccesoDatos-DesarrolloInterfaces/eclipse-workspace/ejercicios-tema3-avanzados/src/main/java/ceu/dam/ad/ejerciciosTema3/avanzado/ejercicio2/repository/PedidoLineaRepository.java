package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Articulo;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.PedidoLinea;
import java.util.List;

@Repository
public interface PedidoLineaRepository extends JpaRepository <PedidoLinea, UUID>{
	
	List<PedidoLinea> findByArticulo(Articulo articulo);
	
	List<PedidoLinea> findByCantidad(Integer cantidad);
	
	List<PedidoLinea> findByNumLinea(Integer numLinea);
	
	List<PedidoLinea> findByUidLinea(UUID uidLinea);
	
	

}
