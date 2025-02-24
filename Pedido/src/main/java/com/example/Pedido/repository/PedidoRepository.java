package com.example.Pedido.repository;

import com.example.Pedido.model.PedidoVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    //List<PedidoVO> findByPublishedTrue();
    List<PedidoVO>  findAll();
    Optional<PedidoVO> getPedidoById();
    List<PedidoVO> findByEstado(String estado);
    //List<PedidoVO> findByPublished(boolean published);
}
