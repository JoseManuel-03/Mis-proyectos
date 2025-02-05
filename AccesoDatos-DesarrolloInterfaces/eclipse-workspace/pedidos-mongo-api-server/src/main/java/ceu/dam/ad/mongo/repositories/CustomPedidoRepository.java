package ceu.dam.ad.mongo.repositories;

import java.util.List;

import ceu.dam.ad.mongo.model.Pedido;

public interface CustomPedidoRepository {

	public List<Pedido> buscarPorPedidosClientes(String dni);
}
