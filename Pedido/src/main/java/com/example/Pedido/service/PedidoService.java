package com.example.Pedido.service;

import com.example.Pedido.model.PedidoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<PedidoDto> getAllPedidos(); //funciona
    Optional<PedidoDto> getPedidoById(String id); //funciona
    List<PedidoDto> findByTipo(String tipo);
    List<PedidoDto> findByEstado(String estado); //funciona
    PedidoDto save(PedidoDto pedido); //funciona
    PedidoDto updatePedido(PedidoDto pedido, String id); //funciona
    ResponseEntity deletePedido(String id); //funciona
}
