package demo.controller.impl;

import demo.model.InventarioDto;
import demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {

    private InventarioService inventarioService;

    @PostMapping("/entrada")
    public ResponseEntity<String> registrarEntrada(@RequestParam String idProducto, @RequestParam int cantidad, @RequestParam String ubicacion) {
        return inventarioService.registrarEntrada(idProducto, cantidad, ubicacion);
    }

    @PostMapping("/salida")
    public ResponseEntity<String> registrarSalida(@RequestParam String idProducto, @RequestParam int cantidad) {
        return inventarioService.registrarSalida(idProducto, cantidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<InventarioDto>> consultarInventario(@PathVariable String id) {
        return ResponseEntity.ok(inventarioService.consultarInventario(id));
    }
}
