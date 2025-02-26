package demo.controller.impl;

import demo.model.InventarioDto;
import demo.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventario")
@Tag(name = "Inventario", description = "API para gestionar el inventario") // Organiza los endpoints en Swagger
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Operation(summary = "Registrar entrada de productos", description = "Aumenta el stock de un producto en el inventario")
    @PostMapping("/entrada")
    public ResponseEntity<String> registrarEntrada(@RequestParam String idProducto, @RequestParam int cantidad, @RequestParam String ubicacion) {
        return inventarioService.registrarEntrada(idProducto, cantidad, ubicacion);
    }

    @Operation(summary = "Registrar salida de productos", description = "Reduce el stock de un producto en el inventario")
    @PostMapping("/salida")
    public ResponseEntity<String> registrarSalida(@RequestParam String idProducto, @RequestParam int cantidad) {
        return inventarioService.registrarSalida(idProducto, cantidad);
    }

    @Operation(summary = "Consultar inventario por ID", description = "Obtiene información del inventario de un producto específico")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<InventarioDto>> consultarInventario(@PathVariable String id) {
        return ResponseEntity.ok(inventarioService.consultarInventario(id));
    }
}
