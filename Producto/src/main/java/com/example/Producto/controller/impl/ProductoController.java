package com.example.Producto.controller.impl;

import com.example.Producto.controller.ProductoAPI;
import com.example.Producto.model.ProductoDto;
import com.example.Producto.repository.ProductoRepository;
import com.example.Producto.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Productos", description = "API para gestionar productos") // Organiza los endpoints en Swagger
public class ProductoController implements ProductoAPI {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Operation(summary = "Obtener todos los productos", description = "Retorna la lista completa de productos almacenados")
    @GetMapping("/producto")
    public List<ProductoDto> getAllProducto() {
        return productoService.getAllProducto();
    }

    @Override
    @Operation(summary = "Buscar un producto por ID", description = "Obtiene un producto específico a partir de su ID")
    @GetMapping("/producto/{id}")
    public Optional<ProductoDto> getProductoById(@PathVariable String id) {
        return productoService.getProductoById(id);
    }

    @Override
    @Operation(summary = "Buscar productos por nombre", description = "Obtiene productos que coincidan con el nombre proporcionado")
    @GetMapping("/producto/title/{nombre}")
    public List<ProductoDto> buscarPorNombre(@PathVariable String nombre) {
        return productoService.buscarPorNombre(nombre);
    }

    @Override
    @Operation(summary = "Crear un nuevo producto", description = "Guarda un nuevo producto en la base de datos")
    @PostMapping("/producto")
    public ProductoDto guardar(@RequestBody ProductoDto productoDto) {
        return productoService.guardar(productoDto);
    }

    @Override
    @Operation(summary = "Actualizar un producto", description = "Modifica los datos de un producto existente por su ID")
    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(
            @RequestBody ProductoDto producto,
            @PathVariable String id) {

        ProductoDto updatedProducto = productoService.actualizarProducto(producto, id);

        if (updatedProducto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(updatedProducto);
    }

    @Override
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto de la base de datos por su ID")
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String id) {
        return productoService.eliminarProducto(id);
    }
}
