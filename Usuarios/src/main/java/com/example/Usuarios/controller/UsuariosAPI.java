package com.example.Usuarios.controller;

import com.example.Usuarios.model.UsuariosDto;
import com.example.Usuarios.model.UsuariosDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuariosAPI {
    List<UsuariosDto> getAllUsuarios();
    Optional<UsuariosDto> getUsuarioById(Integer id);
    UsuariosDto save(UsuariosDto usuario);
    UsuariosDto updateUsuario(UsuariosDto usuario, Integer id);
    ResponseEntity<?> deleteUsuario(Integer id);
    ResponseEntity<?> deleteAllUsuarios();
}
