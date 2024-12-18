package ceu.dam.ad.tema3.ejercicios.ejercicio04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.PedidoLinea;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.PedidoLineaKey;
@Repository
public interface PedidoLineaRepository extends JpaRepository<PedidoLinea, PedidoLineaKey>{
	
	public List<PedidoLinea> findByIdPedido(Long id);
	
	

}
