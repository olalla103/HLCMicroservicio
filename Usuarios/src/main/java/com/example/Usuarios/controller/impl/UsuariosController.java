package com.example.Usuarios.controller.impl;

import com.example.Usuarios.controller.UsuariosAPI;
import com.example.Usuarios.model.UsuariosDto;
import com.example.Usuarios.service.UsuariosService;
import com.example.Usuarios.controller.UsuariosAPI;
import com.example.Usuarios.model.UsuariosDto;
import com.example.Usuarios.repository.UsuariosRepository;
import com.example.Usuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController implements UsuariosAPI {
    @Autowired
    private UsuariosService usuarioService;

    @Override
    @GetMapping("/usuarios")
    public List<UsuariosDto> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @Override
    @GetMapping("/usuarios/{id}")
    public Optional<UsuariosDto> getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @Override
    @PostMapping("/usuarios")
    public UsuariosDto save(@RequestBody UsuariosDto usuarioDto) {
        return usuarioService.save(usuarioDto);
    }

    @Override
    @PutMapping("/usuarios/{id}")
    public UsuariosDto updateUsuario(@RequestBody UsuariosDto usuarioDto, @PathVariable Integer id) {
        return usuarioService.updateUsuario(usuarioDto, id);
    }

    @Override
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
        return usuarioService.deleteUsuario(id);
    }

    @Override
    @DeleteMapping("/usuarios")
    public ResponseEntity<?> deleteAllUsuarios() {
        return usuarioService.deleteAllUsuarios();
    }
}
