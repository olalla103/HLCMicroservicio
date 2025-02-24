package com.example.Pedido.model;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PedidoDto {

    private String id;
    private String tipo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Object[] listaProductos;

}
