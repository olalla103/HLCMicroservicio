package demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class InventarioVO {

    @Id
    private String id;
    private Map<String, Integer> stock; // Producto ID -> Stock
    private Map<String, String> ubicaciones; // Producto ID -> Ubicación
}
