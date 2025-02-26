package com.example.Pedido.util;

import com.example.Pedido.model.PedidoVO;
import com.example.Pedido.model.PedidoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static PedidoVO pedidoMapperDtoToEntity(PedidoDto pedido) {
        return PedidoVO.builder()
                .id(pedido.getId())
                .tipo(pedido.getTipo())
                .estado(pedido.getEstado())
                .fechaCreacion(pedido.getFechaCreacion())
                .listaProductos(
                        pedido.getListaProductos() != null ?
                                pedido.getListaProductos().stream()
                                        .map(ProductoMapper::productoMapperDtoToEntity)
                                        .collect(Collectors.toList())
                                : new ArrayList<>()
                )
                .build();
    }


    public static PedidoDto pedidoMapperEntityToDto(PedidoVO pedidoVO) {
        return PedidoDto.builder()
                .id(pedidoVO.getId())
                .tipo(pedidoVO.getTipo())
                .estado(pedidoVO.getEstado())
                .fechaCreacion(pedidoVO.getFechaCreacion())
                .listaProductos(
                        pedidoVO.getListaProductos() != null ?
                                pedidoVO.getListaProductos().stream()
                                        .map(ProductoMapper::productoMapperEntityToDto)
                                        .collect(Collectors.toList())
                                : new ArrayList<>()
                )
                .build();
    }



    public static List<PedidoVO> pedidoListMapperDtoToEntity(List<PedidoDto> PedidoDtoList) {
        return PedidoDtoList.stream()
                .map(PedidoMapper::pedidoMapperDtoToEntity)
                .collect(Collectors.toList());
    }


    public static List<PedidoDto> pedidoListMapperEntityToDto(List<PedidoVO> PedidoVOList) {
        return PedidoVOList.stream()
                .map(PedidoMapper::pedidoMapperEntityToDto)
                .collect(Collectors.toList());
    }
}
