package com.example.Producto.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private String ubicacion;
}
