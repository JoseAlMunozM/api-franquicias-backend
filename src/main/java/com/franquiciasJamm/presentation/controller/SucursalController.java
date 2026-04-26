package com.franquiciasJamm.presentation.controller;

import com.franquiciasJamm.domain.model.Sucursal;
import com.franquiciasJamm.application.service.SucursalService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService service;

    public SucursalController(SucursalService service) {
        this.service = service;
    }

    @PostMapping("/{franquiciaId}")
    public Sucursal crear(@PathVariable Long franquiciaId,
                          @RequestBody Sucursal sucursal) {
        return service.crear(franquiciaId, sucursal);
    }

    @PutMapping("/{id}/nombre")
    public Sucursal actualizarNombre(@PathVariable Long id,
                                     @RequestParam String nombre) {
        return service.actualizarNombre(id, nombre);
    }
}