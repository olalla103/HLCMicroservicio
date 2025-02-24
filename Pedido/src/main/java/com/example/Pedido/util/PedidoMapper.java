package com.example.Pedido.util;

import com.example.Pedido.model.PedidoVO;
import com.example.Pedido.model.PedidoDto;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static PedidoVO pedidoMapperDtoToEntity(PedidoDto pedido){
        return PedidoVO.builder()
                .id(pedido.getId())
                .tipo(pedido.getTipo())
                .estado(pedido.getEstado())
                .fechaCreacion(pedido.getFechaCreacion())
                .listaProductos(pedido.getListaProductos())
                .build();
    }

    public static PedidoDto pedidoMapperEntityToDto(PedidoVO PedidoVO){
        return PedidoDto.builder()
                .id(PedidoVO.getId())
                .tipo(PedidoVO.getTipo())
                .estado(PedidoVO.getEstado())
                .fechaCreacion(PedidoVO.getFechaCreacion())
                .listaProductos(PedidoVO.getListaProductos())
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
