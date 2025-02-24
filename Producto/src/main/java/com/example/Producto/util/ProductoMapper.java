package com.example.Producto.util;

import com.example.Producto.model.Producto;
import com.example.Producto.model.ProductoDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoMapper {

    public static Producto productoMapperDtoToEntity(ProductoDto producto){
        return Producto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())

                .build();
    }

    public static ProductoDto productoMapperEntityToDto(Producto producto){
        return ProductoDto.builder()
                .id(producto.getId())
                .title(producto.getTitle())
                .description(producto.getDescription())
                .published(producto.getPublished())
                .build();
    }


    public static List<Producto> productoListMapperDtoToEntity(List<ProductoDto> productoDtoList) {
        return productoDtoList.stream()
                .map(ProductoMapper::productoMapperDtoToEntity)
                .collect(Collectors.toList());
    }


    public static List<ProductoDto> productoListMapperEntityToDto(List<Producto> productoList) {
        return productoList.stream()
                .map(ProductoMapper::productoMapperEntityToDto)
                .collect(Collectors.toList());
    }

}
