package demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD:Inventario/src/main/java/demo/model/InventarioVO.java
import java.util.Map;
=======
import java.time.LocalDateTime;
import java.util.List;
>>>>>>> Andres:Pedido/src/main/java/com/example/Pedido/model/PedidoVO.java

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class InventarioVO {

    @Id
    private String id;
<<<<<<< HEAD:Inventario/src/main/java/demo/model/InventarioVO.java
    private Map<String, Integer> stock; // Producto ID -> Stock
    private Map<String, String> ubicaciones; // Producto ID -> Ubicación
=======
    private String tipo; // Entrada o salida
    private String estado; // Pendiente, procesado o cancelado
    private LocalDateTime fechaCreacion;
    private List<ProductoVO> listaProductos;
>>>>>>> Andres:Pedido/src/main/java/com/example/Pedido/model/PedidoVO.java
}
