package com.example.Producto.controller;

import com.example.Producto.model.ProductoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoAPI {
    List<ProductoDto> getAllProducto();

    Optional<ProductoDto> getProductoById(String id);

    List<ProductoDto> buscarPorNombre(String nombre);

    ProductoDto guardar(ProductoDto ProductoDto);

    ProductoDto actualizarProducto(ProductoDto productoDto, Integer id);

    ResponseEntity eliminarProducto(Integer id);

}
