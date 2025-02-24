package com.example.Usuarios.service.impl;

import com.example.Usuarios.model.Usuarios;
import com.example.Usuarios.model.UsuariosDto;
import com.example.Usuarios.repository.UsuariosRepository;
import com.example.Usuarios.service.UsuariosService;
import com.example.Usuarios.util.UsuariosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuarioRepository;

    @Override
    public List<UsuariosDto> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuariosMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuariosDto> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).map(UsuariosMapper::toDto);
    }

    @Override
    public UsuariosDto save(UsuariosDto usuarioDto) {
        Usuarios usuario = UsuariosMapper.toEntity(usuarioDto);
        Usuarios saved = usuarioRepository.save(usuario);
        return UsuariosMapper.toDto(saved);
    }

    @Override
    public UsuariosDto updateUsuario(UsuariosDto usuarioDto, Integer id) {
        return usuarioRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(usuarioDto.getNombre());
                    existing.setRol(usuarioDto.getRol());
                    Usuarios updated = usuarioRepository.save(existing);
                    return UsuariosMapper.toDto(updated);
                })
                .orElse(null);
    }

    @Override
    public ResponseEntity<?> deleteUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + id);
        }
    }

    @Override
    public ResponseEntity<?> deleteAllUsuarios() {
        usuarioRepository.deleteAll();
        return ResponseEntity.ok("Todos los usuarios fueron eliminados exitosamente");
    }
}
