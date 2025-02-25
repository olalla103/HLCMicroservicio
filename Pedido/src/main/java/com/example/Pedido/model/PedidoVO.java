package com.example.Pedido.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class PedidoVO {

    @Id
    private String id;
    private String tipo; // Entrada o salida
    private String estado; // Pendiente, procesado o cancelado
    private LocalDateTime fechaCreacion;
    private List<ProductoVO> listaProductos;
}
