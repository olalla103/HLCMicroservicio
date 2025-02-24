package com.example.Pedido.controller;

import com.example.Pedido.model.PedidoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoAPI {
    List<PedidoDto> getAllPedidos();
    Optional<PedidoDto> getPedidoById(String id);
    List<PedidoDto> findByEstado(String id);
    PedidoDto save(PedidoDto Pedido);
    PedidoDto updatePedido(PedidoDto pedido, String id);
    ResponseEntity deletePedido(String id);
    //List<PedidoDto>findByPublished();
    //ResponseEntity deleteAllPedidos();
}
