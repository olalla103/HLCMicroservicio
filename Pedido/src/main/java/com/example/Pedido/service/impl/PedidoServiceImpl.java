package com.example.Pedido.service.impl;

import com.example.Pedido.model.PedidoVO;
import com.example.Pedido.model.PedidoDto;
import com.example.Pedido.model.ProductoVO;
import com.example.Pedido.repository.PedidoRepository;
import com.example.Pedido.service.PedidoService;
import com.example.Pedido.util.PedidoMapper;
import com.example.Pedido.util.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoDto> getAllPedidos(){
        List<PedidoVO> PedidoVOList = pedidoRepository.findAll();
        return PedidoVOList.stream()
                .map(PedidoMapper::pedidoMapperEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PedidoDto> getPedidoById(String id) {
        Optional<PedidoVO> pedidoOptional = pedidoRepository.findById(id);

        return pedidoOptional.map(PedidoMapper::pedidoMapperEntityToDto);
    }

    @Override
    public List<PedidoDto> findByEstado(String estado) {
        List<PedidoVO> pedidoOptional = pedidoRepository.findByEstado(estado);

        return PedidoMapper.pedidoListMapperEntityToDto(pedidoOptional);
    }

    @Override
    public List<PedidoDto> findByTipo(String tipo) {
        List<PedidoVO> pedidoOptional = pedidoRepository.findByTipo(tipo);

        return PedidoMapper.pedidoListMapperEntityToDto(pedidoOptional);
    }

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        PedidoVO PedidoVO = PedidoMapper.pedidoMapperDtoToEntity(pedidoDto);
        PedidoVO savedPedidoEntity = pedidoRepository.save(PedidoVO);
        return PedidoMapper.pedidoMapperEntityToDto(savedPedidoEntity);
    }

    @Override
    public PedidoDto updatePedido(PedidoDto pedido, String id) {
        Optional<PedidoVO> existingPedidoOptional = pedidoRepository.findById(id);

        if (existingPedidoOptional.isPresent()) {
            PedidoVO existingPedido = existingPedidoOptional.get();
            existingPedido.setEstado(pedido.getEstado());
            existingPedido.setTipo(pedido.getTipo());
            existingPedido.setFechaCreacion(pedido.getFechaCreacion());

            // Convertir la lista de ProductoDto a ProductoVO
            List<ProductoVO> listaProductosVO = pedido.getListaProductos().stream()
                    .map(ProductoMapper::productoMapperDtoToEntity)
                    .collect(Collectors.toList());

            existingPedido.setListaProductos(listaProductosVO);

            PedidoVO updatedPedido = pedidoRepository.save(existingPedido);

            return PedidoMapper.pedidoMapperEntityToDto(updatedPedido);
        } else {
            return null;
        }
    }


    @Override
    public ResponseEntity deletePedido(String id) {
        try {
            Optional<PedidoVO> existingPedidoOptional = pedidoRepository.findById(id);
            if (existingPedidoOptional.isPresent()) {
                pedidoRepository.deleteById(id);
                return ResponseEntity.ok("Pedido eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el pedido");
        }
    }
}
