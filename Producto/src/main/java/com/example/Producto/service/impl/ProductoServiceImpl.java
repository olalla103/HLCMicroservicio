package com.example.Producto.service.impl;

import com.example.Producto.model.Producto;
import com.example.Producto.model.ProductoDto;
import com.example.Producto.repository.ProductoRepository;
import com.example.Producto.service.ProductoService;
import com.example.Producto.util.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> getAllProducto(){
        List<Producto> productoList = productoRepository.findAll();
        return productoList.stream()
                .map(ProductoMapper::productoMapperEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDto> getProductoById(String id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        return productoOptional.map(ProductoMapper::productoMapperEntityToDto);
    }

    @Override
    public List<ProductoDto> buscarPorNombre(String nombre) {
        List<Producto> productoOptional = productoRepository.findByNombre(nombre);

        return ProductoMapper.productoListMapperEntityToDto(productoOptional);
    }

    @Override
    public ProductoDto guardar(ProductoDto productoDto) {
        Producto producto = ProductoMapper.productoMapperDtoToEntity(productoDto);
        Producto savedProductoEntity = productoRepository.save(producto);
        return ProductoMapper.productoMapperEntityToDto(savedProductoEntity);
    }

    @Override
    public ProductoDto actualizarProducto(ProductoDto producto, String id) {
        Optional<Producto> existingProductoOptional = productoRepository.findById(id);

        if (existingProductoOptional.isPresent()) {
            Producto existingProducto = existingProductoOptional.get();
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setStock(producto.getStock());
            existingProducto.setUbicacion(producto.getUbicacion());

            Producto updatedProducto = productoRepository.save(existingProducto);

            return ProductoMapper.productoMapperEntityToDto(updatedProducto);
        } else {
            return null;
        }
    }


    @Override
    public ResponseEntity eliminarProducto(String id) {
        try {
            Optional<Producto> existingProductoOptional = productoRepository.findById(id);
            if (existingProductoOptional.isPresent()) {
                productoRepository.deleteById(id);
                return ResponseEntity.ok("Producto eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el producto");
        }
    }


}
