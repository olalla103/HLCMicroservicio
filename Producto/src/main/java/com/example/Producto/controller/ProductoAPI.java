package com.example.Producto.controller;

import com.example.Producto.model.ProductoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoAPI {
    List<ProductoDto> getAllProducto();
    Optional<ProductoDto> getProductoId(String id);
    List<ProductoDto> buscarPorNombre(String nombre);
    ProductoDto guardar(ProductoDto ProductoDto);
    ProductoDto actualizarProducto(ProductoDto productoDto, String id);
    ResponseEntity eliminarProducto(Integer id);

//    List<ProductoDto> getAllProducto();
//    Optional<ProductoDto> getProductoId(String id);
//    List<ProductoDto> buscarPorNombre(String id);
//    List<ProductoDto>findByPublished();
//    ProductoDto guardar(ProductoDto Producto);
//    ProductoDto actualizarProducto(ProductoDto productoDto, String id);
//    ResponseEntity eliminarProducto(String id);
//    ResponseEntity deleteAllProducto();
}
