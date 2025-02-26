package demo.service;

import demo.model.InventarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    ResponseEntity<String> registrarEntrada(String idProducto, int cantidad, String ubicacion);
    ResponseEntity<String> registrarSalida(String idProducto, int cantidad);
    int consultarStock(String idProducto);

    List<String> alertarStockBajo();

    String generarInformeInventario();
}
