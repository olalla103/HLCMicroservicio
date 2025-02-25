package com.example.Pedido.repository;

import com.example.Pedido.model.PedidoVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends MongoRepository<PedidoVO, String> {
    List<PedidoVO>  findAll();
    Optional<PedidoVO> findById(String id);
    List<PedidoVO> findByEstado(String estado);
    List<PedidoVO> findByTipo(String tipo);
}
