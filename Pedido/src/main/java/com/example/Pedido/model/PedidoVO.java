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
public class PedidoVO {

    @Id
    private String id;
    private String tipo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Object[] listaProductos;
}
