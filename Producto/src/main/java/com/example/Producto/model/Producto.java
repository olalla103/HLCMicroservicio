package com.example.Producto.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@Getter
@Setter
@Builder
public class Producto {
    private String id;  // Cambiar de Integer a String porque MongoDB usa ObjectId
    private String nombre;
    private String descripcion;
    private Integer stock;
    private String ubicacion;
}
