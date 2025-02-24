package com.example.Usuarios.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "usuarios")
public class UsuariosDto {
    @Id
    private Integer id;
    private String nombre;
    private String rol;
}