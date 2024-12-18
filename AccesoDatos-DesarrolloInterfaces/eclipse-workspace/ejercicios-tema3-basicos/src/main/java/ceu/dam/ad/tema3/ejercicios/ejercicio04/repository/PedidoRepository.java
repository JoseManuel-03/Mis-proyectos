package ceu.dam.ad.tema3.ejercicios.ejercicio04.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	public Optional<Pedido> findByIdPedido(Long id);

	
}
