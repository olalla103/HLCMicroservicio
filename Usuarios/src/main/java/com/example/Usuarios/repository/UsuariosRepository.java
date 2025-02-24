package com.example.Usuarios.repository;

import com.example.Usuarios.model.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuariosRepository extends MongoRepository<Usuarios, Integer> {
    Optional<Usuarios> findById(Integer id);
}
