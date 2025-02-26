package demo.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDto {

    private Map<String, Integer> stock = new HashMap<>(); // Producto ID -> Stock
    private Map<String, String> ubicaciones = new HashMap<>(); // Producto ID -> Ubicación

    // Registrar entrada de productos (Aumenta el stock)
    public void registrarEntrada(String idProducto, int cantidad, String ubicacion) {
        stock.put(idProducto, stock.get(idProducto) + cantidad);
        ubicaciones.put(idProducto, ubicacion);
        System.out.println("Entrada registrada: " + cantidad + " unidades de " + idProducto);
    }

    // Registrar salida de productos (Disminuye el stock si es suficiente)
    public boolean registrarSalida(String idProducto, int cantidad) {
        if (stock.getOrDefault(idProducto, 0) >= cantidad) {
            stock.put(idProducto, stock.get(idProducto) - cantidad);
            System.out.println("Salida registrada: " + cantidad + " unidades de " + idProducto);
            return true;
        } else {
            System.out.println("Stock insuficiente para el producto: " + idProducto);
            return false;
        }
    }

    // Consultar stock disponible
    public int consultarStock(String idProducto) {
        return stock.get(idProducto);
    }

    // Obtener la ubicación de un producto
    public String obtenerUbicacion(String idProducto) {
        return ubicaciones.getOrDefault(idProducto, "Ubicación no asignada");
    }
}
