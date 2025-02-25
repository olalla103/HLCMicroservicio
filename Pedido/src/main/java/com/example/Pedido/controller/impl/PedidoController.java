package com.example.Pedido.controller.impl;

import com.example.Pedido.controller.PedidoAPI;
import com.example.Pedido.model.PedidoDto;
import com.example.Pedido.repository.PedidoRepository;
import com.example.Pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PedidoController implements PedidoAPI {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    @GetMapping("/pedidos")
    public List<PedidoDto> getAllPedidos(){return pedidoService.getAllPedidos();}

    @Override
    @GetMapping("/Pedido/{id}")
    public Optional<PedidoDto> getPedidoById(@PathVariable String id) {
        return pedidoService.getPedidoById(id);
    }

    @Override
    @GetMapping("/pedidos/estado/{estado}")
    public List<PedidoDto> findByEstado(@PathVariable String estado) {
        return pedidoService.findByEstado(estado);
    }

    @Override
    @GetMapping("/pedidos/tipo/{tipo}")
    public List<PedidoDto> findByTipo(@PathVariable String tipo) {
        return pedidoService.findByTipo(tipo);
    }

    @Override
    @PostMapping("/pedidos")
    public PedidoDto save(@RequestBody PedidoDto pedidoDto) {
        return pedidoService.save(pedidoDto);
    }

    @Override
    @PutMapping("/pedidos/{id}")
    public PedidoDto updatePedido(@RequestBody PedidoDto pedido,@PathVariable String id) {
        return pedidoService.updatePedido(pedido, id);
    }

    @Override
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity deletePedido(@PathVariable String id) {
        return pedidoService.deletePedido(id);
    }
}
