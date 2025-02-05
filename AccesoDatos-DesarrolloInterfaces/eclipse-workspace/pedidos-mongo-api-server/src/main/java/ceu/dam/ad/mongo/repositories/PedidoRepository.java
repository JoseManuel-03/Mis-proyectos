package ceu.dam.ad.mongo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>, CustomPedidoRepository{
	
	List<Pedido> findByNumero(Integer numero);
	
	List<Pedido> findByCliente(Cliente cliente);
	
	List<Pedido> findByFechaBetween(LocalDate desde, LocalDate hasta);
	


}
