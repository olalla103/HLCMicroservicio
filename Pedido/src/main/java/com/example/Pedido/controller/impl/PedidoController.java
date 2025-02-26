package com.example.Pedido.controller.impl;

import com.example.Pedido.controller.PedidoAPI;
import com.example.Pedido.model.PedidoDto;
import com.example.Pedido.repository.PedidoRepository;
import com.example.Pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Pedidos", description = "API para la gestión de pedidos")
public class PedidoController implements PedidoAPI {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Operation(summary = "Obtener todos los pedidos", description = "Retorna la lista de todos los pedidos almacenados en la base de datos")
    @GetMapping("/pedidos")
    public List<PedidoDto> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @Override
    @Operation(summary = "Buscar un pedido por ID", description = "Retorna un pedido específico según su ID")
    @GetMapping("/pedidos/{id}")
    public Optional<PedidoDto> getPedidoById(@PathVariable String id) {
        return pedidoService.getPedidoById(id);
    }

    @Override
    @Operation(summary = "Buscar pedidos por estado", description = "Filtra los pedidos según su estado (Ej: 'Pendiente', 'Enviado', 'Entregado')")
    @GetMapping("/pedidos/estado/{estado}")
    public List<PedidoDto> findByEstado(@PathVariable String estado) {
        return pedidoService.findByEstado(estado);
    }

    @Override
    @Operation(summary = "Buscar pedidos por tipo", description = "Filtra los pedidos según su tipo (Ej: 'Normal', 'Express')")
    @GetMapping("/pedidos/tipo/{tipo}")
    public List<PedidoDto> findByTipo(@PathVariable String tipo) {
        return pedidoService.findByTipo(tipo);
    }

    @Override
    @Operation(summary = "Crear un nuevo pedido", description = "Guarda un nuevo pedido en la base de datos")
    @PostMapping("/pedidos")
    public PedidoDto save(@RequestBody PedidoDto pedidoDto) {
        return pedidoService.save(pedidoDto);
    }

    @Override
    @Operation(summary = "Actualizar un pedido", description = "Modifica un pedido existente con los nuevos datos")
    @PutMapping("/pedidos/{id}")
    public PedidoDto updatePedido(@RequestBody PedidoDto pedido, @PathVariable String id) {
        return pedidoService.updatePedido(pedido, id);
    }

    @Override
    @Operation(summary = "Eliminar un pedido", description = "Elimina un pedido de la base de datos según su ID")
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable String id) {
        return pedidoService.deletePedido(id);
    }
}
