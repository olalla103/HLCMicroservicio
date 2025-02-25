package com.example.Pedido.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class PedidoDto {

    private String id;
    private String tipo; //Entrada o salida
    private String estado; //Pendiente, procesado o cancelado
    private LocalDateTime fechaCreacion;
    private List<ProductoDto> listaProductos;

}
