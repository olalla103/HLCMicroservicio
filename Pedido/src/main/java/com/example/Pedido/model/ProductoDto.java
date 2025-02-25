package com.example.Pedido.model;

import lombok.*;

@Getter
@Setter
@Builder
public class ProductoDto {

    private String id;
    private String nombre;
    private int stock;
    private String descripcion;
    private String ubicacion;

}