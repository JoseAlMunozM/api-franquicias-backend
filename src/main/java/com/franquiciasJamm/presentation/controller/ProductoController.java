package com.franquiciasJamm.presentation.controller;

import com.franquiciasJamm.domain.model.Producto;
import com.franquiciasJamm.application.service.ProductoService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping("/{sucursalId}")
    public Producto crear(@PathVariable Long sucursalId,
                          @RequestBody Producto producto) {
        return service.crear(sucursalId, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}/stock")
    public Producto actualizarStock(@PathVariable Long id,
                                   @RequestParam Integer stock) {
        return service.actualizarStock(id, stock);
    }

    @PutMapping("/{id}/nombre")
    public Producto actualizarNombre(@PathVariable Long id,
                                     @RequestParam String nombre) {
        return service.actualizarNombre(id, nombre);
    }
}