package com.example.Pedido.util;

import com.example.Pedido.model.ProductoVO;
import com.example.Pedido.model.ProductoDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoMapper {
    public static ProductoVO productoMapperDtoToEntity(ProductoDto producto){
        return ProductoVO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .descripcion(producto.getDescripcion())
                .ubicacion(producto.getUbicacion())
                .build();
    }

    public static ProductoDto productoMapperEntityToDto(ProductoVO ProductoVO){
        return ProductoDto.builder()
                .id(ProductoVO.getId())
                .nombre(ProductoVO.getNombre())
                .stock(ProductoVO.getStock())
                .descripcion(ProductoVO.getDescripcion())
                .ubicacion(ProductoVO.getUbicacion())
                .build();
    }


    public static List<ProductoVO> productoListMapperDtoToEntity(List<ProductoDto> ProductoDtoList) {
        return ProductoDtoList.stream()
                .map(ProductoMapper::productoMapperDtoToEntity)
                .collect(Collectors.toList());
    }


    public static List<ProductoDto> productoListMapperEntityToDto(List<ProductoVO> ProductoVOList) {
        return ProductoVOList.stream()
                .map(ProductoMapper::productoMapperEntityToDto)
                .collect(Collectors.toList());
    }
}
