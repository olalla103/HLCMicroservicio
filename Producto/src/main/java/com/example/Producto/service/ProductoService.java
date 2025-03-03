package com.example.Producto.service;

import com.example.Producto.model.ProductoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoDto> getAllProducto(); //funciona

    Optional<ProductoDto> getProductoById(String id); //funciona

    List<ProductoDto> buscarPorNombre(String nombre);

    ProductoDto guardar(ProductoDto productoDto); //funciona

    ProductoDto actualizarProducto(ProductoDto productoDto, String id); //funciona

    ResponseEntity eliminarProducto(String id); //funciona

}
