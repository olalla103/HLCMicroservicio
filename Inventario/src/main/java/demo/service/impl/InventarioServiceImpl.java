package demo.service.impl;

import demo.model.InventarioDto;
import demo.model.InventarioVO;
import demo.repository.InventarioRepository;
import demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private InventarioRepository inventarioRepository;

    @Override
    public ResponseEntity<String> registrarEntrada(String idProducto, int cantidad, String ubicacion) {
        InventarioVO inventario = inventarioRepository.findById("1").orElseGet(InventarioVO::new);

        inventario.getStock().put(idProducto, inventario.getStock().getOrDefault(idProducto, 0) + cantidad);
        inventario.getUbicaciones().put(idProducto, ubicacion);

        inventarioRepository.save(inventario);
        return ResponseEntity.ok("Entrada registrada correctamente.");
    }

    @Override
    public ResponseEntity<String> registrarSalida(String idProducto, int cantidad) {
        InventarioVO inventario = inventarioRepository.findById("1").orElseGet(InventarioVO::new);

        if (inventario.getStock().getOrDefault(idProducto, 0) >= cantidad) {
            inventario.getStock().put(idProducto, inventario.getStock().get(idProducto) - cantidad);
            inventarioRepository.save(inventario);
            return ResponseEntity.ok("Salida registrada correctamente.");
        } else {
            return ResponseEntity.badRequest().body("Stock insuficiente.");
        }
    }

    @Override
    public Optional<InventarioDto> consultarInventario(String id) {
        return inventarioRepository.findById(id)
                .map(inventarioVO -> new InventarioDto(inventarioVO.getStock(), inventarioVO.getUbicaciones()));
    }
}
