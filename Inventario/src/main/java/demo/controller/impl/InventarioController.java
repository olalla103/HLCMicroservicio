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

    @Operation(summary = "Consultar stock de un producto", description = "Obtiene la cantidad de stock disponible para un producto específico")
    @GetMapping("/stock/{idProducto}")
    public ResponseEntity<Integer> consultarStock(@PathVariable String idProducto) {
        return ResponseEntity.ok(inventarioService.consultarStock(idProducto));
    }

}
