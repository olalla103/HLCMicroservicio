package com.example.Producto.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    private String id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private String ubicacion;
}

