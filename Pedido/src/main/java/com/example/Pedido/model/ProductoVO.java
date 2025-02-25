package com.example.Pedido.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ProductoVO {

    @Id
    private String id;
    private String nombre;
    private int stock;
    private String descripcion;
    private String ubicacion;
}
