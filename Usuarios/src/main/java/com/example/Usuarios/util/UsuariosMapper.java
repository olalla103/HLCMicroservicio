package com.example.Usuarios.util;
import com.example.Usuarios.model.Usuarios;
import com.example.Usuarios.model.UsuariosDto;

public class UsuariosMapper {

    public static Usuarios toEntity(UsuariosDto dto) {
        return Usuarios.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .rol(dto.getRol())
                .build();
    }

    public static UsuariosDto toDto(Usuarios entity) {
        return UsuariosDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .rol(entity.getRol())
                .build();
    }
}
