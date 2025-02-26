package demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.InventarioDto;
import demo.model.InventarioVO;
import demo.repository.InventarioRepository;
import demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventarioServiceImpl implements InventarioService {

    private static final String INVENTARIO_ID = "inventario_general"; // 🔹 Definir ID único del inventario

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public ResponseEntity<String> registrarEntrada(String idProducto, int cantidad, String ubicacion) {
        // 🔹 Buscar el único inventario
        Optional<InventarioVO> optionalInventario = inventarioRepository.findById(INVENTARIO_ID);
        if (optionalInventario.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el inventario.");
        }

        InventarioVO inventario = optionalInventario.get();
        inventario.getStock().put(idProducto, inventario.getStock().getOrDefault(idProducto, 0) + cantidad);
        inventario.getUbicaciones().put(idProducto, ubicacion);

        inventarioRepository.save(inventario);
        return ResponseEntity.ok("✅ Entrada registrada correctamente.");
    }

    @Override
    public ResponseEntity<String> registrarSalida(String idProducto, int cantidad) {
        Optional<InventarioVO> optionalInventario = inventarioRepository.findById(INVENTARIO_ID);
        if (optionalInventario.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontró el inventario.");
        }

        InventarioVO inventario = optionalInventario.get();
        int stockActual = inventario.getStock().getOrDefault(idProducto, 0);

        if (stockActual >= cantidad) {
            inventario.getStock().put(idProducto, stockActual - cantidad);
            inventarioRepository.save(inventario);
            return ResponseEntity.ok("✅ Salida registrada correctamente.");
        } else {
            return ResponseEntity.badRequest().body("Stock insuficiente.");
        }
    }

    @Override
    public int consultarStock(String idProducto) {
        Optional<InventarioVO> optionalInventario = inventarioRepository.findById(INVENTARIO_ID);

        if (optionalInventario.isEmpty()) {
            return 0; // Si no hay inventario, asumimos stock 0
        }

        InventarioVO inventario = optionalInventario.get();
        return inventario.getStock().getOrDefault(idProducto, 0);
    }


    //Método para alertar cuando un producto tiene stock ≤ 5
    @Override
    public List<String> alertarStockBajo() {
        Optional<InventarioVO> optionalInventario = inventarioRepository.findById(INVENTARIO_ID);


        InventarioVO inventario = optionalInventario.get();
        Map<String, Integer> stock = inventario.getStock();
        List<String> alertas = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            if (entry.getValue() <= 5) {
                alertas.add("Alerta: El producto " + entry.getKey() + " tiene un stock bajo de " + entry.getValue());
            }
        }

        return alertas;
    }

    //Método para generar un JSON con el informe del inventario
    @Override
    public String generarInformeInventario() {
        Optional<InventarioVO> optionalInventario = inventarioRepository.findById(INVENTARIO_ID);


        InventarioVO inventario = optionalInventario.get();
        Map<String, Integer> stock = inventario.getStock();

        try {
            return new ObjectMapper().writeValueAsString(stock);
        } catch (Exception e) {
            e.printStackTrace();
            return " No se pudo generar el informe";
        }
    }
}
