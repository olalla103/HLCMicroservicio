package com.example.Usuarios.service;
import com.example.Usuarios.model.UsuariosDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    List<UsuariosDto> getAllUsuarios();
    Optional<UsuariosDto> getUsuarioById(Integer id);
    UsuariosDto save(UsuariosDto usuario);
    UsuariosDto updateUsuario(UsuariosDto usuario, Integer id);
    ResponseEntity<?> deleteUsuario(Integer id);
    ResponseEntity<?> deleteAllUsuarios();
}