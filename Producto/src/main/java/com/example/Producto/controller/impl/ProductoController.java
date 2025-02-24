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
    public List<ProductoDto> getAllProducto(){return productoService.getAllProducto();}

    @Override
    public Optional<ProductoDto> getProductoId(String id) {
        return Optional.empty();
    }

    @Override
    @GetMapping("/producto/{id}")
    public Optional<ProductoDto> getTutorialById(@PathVariable String id) {
        return productoService.getTutorialById(id);
    }

    @Override
    @GetMapping("/producto/title/{nombre}")
    public List<ProductoDto> buscarPorNombre(@PathVariable String nombre) {
        return productoService.findByTitleContaining(nombre);
    }

    @Override
    @GetMapping("/producto/published")
    public List<ProductoDto> findByPublished() {
        return productoService.findByPublished();
    }

    @Override
    @PostMapping("/producto")
    public ProductoDto guardar(@RequestBody ProductoDto productoDto) {
        return productoService.save(productoDto);
    }

    @Override
    public ProductoDto actualizarProducto(ProductoDto productoDto, String id) {
        return null;
    }

    @Override
    public ResponseEntity eliminarProducto(String id) {
        return null;
    }

    @Override
    @PutMapping("/producto/{id}")
    public ProductoDto updateTutorial(@RequestBody ProductoDto producto, @PathVariable String id) {
        return productoService.updateTutorial(producto);
    }

    @Override
    @DeleteMapping("/producto/{id}")
    public ResponseEntity eliminarProducto(@PathVariable Integer id) {
        return productoService.deleteTutorial(id);
    }

}
