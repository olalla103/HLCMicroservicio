package com.example.Producto.repository;

import com.example.Producto.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    List<Producto> findAll();

    Optional<Producto> findById(String id);

    List<Producto> findByNombre(String nombre);

}
