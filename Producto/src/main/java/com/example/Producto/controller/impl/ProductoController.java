package com.example.Producto.controller.impl;

import com.example.Producto.controller.ProductoAPI;
import com.example.Producto.model.ProductoDto;
import com.example.Producto.repository.ProductoRepository;
import com.example.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoController implements ProductoAPI {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @GetMapping("/producto")
    public List<ProductoDto> getAllProducto() {
        return productoService.getAllProducto();
    }

    @Override
    public Optional<ProductoDto> getProductoById(String id) {
        return Optional.empty();
    }


    @GetMapping("/producto/{id}")
    public Optional<ProductoDto> getTutorialById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @Override
    @GetMapping("/producto/title/{nombre}")
    public List<ProductoDto> buscarPorNombre(@PathVariable String nombre) {
        return productoService.buscarPorNombre(nombre);
    }

    @Override
    @PostMapping("/producto")
    public ProductoDto guardar(@RequestBody ProductoDto productoDto) {
        return productoService.guardar(productoDto);
    }

    @Override
    @PutMapping("/producto/{id}")
    public ProductoDto actualizarProducto(@RequestBody ProductoDto producto, @PathVariable Integer id) {
        return productoService.actualizarProducto(producto, id);
    }

    @Override
    @DeleteMapping("/producto/{id}")
    public ResponseEntity eliminarProducto(@PathVariable Integer id) {
        return productoService.eliminarProducto(id);
    }

}
