package com.example.Producto.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private String ubicacion;

}
