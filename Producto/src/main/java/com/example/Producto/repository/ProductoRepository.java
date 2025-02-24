package com.example.Producto.repository;

import com.example.Producto.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    List<Producto> findByPublishedTrue();
    List<Producto>  findAll();
    Optional<Producto> getTutorialById();
    List<Producto> findByTitleContaining(String title);
    List<Producto> findByPublished(boolean published);
}
