package com.franquiciasJamm.presentation.controller;

import com.franquiciasJamm.domain.model.Franquicia;
import com.franquiciasJamm.application.service.FranquiciaService;
import com.franquiciasJamm.application.dto.TopProductoDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final FranquiciaService service;

    public FranquiciaController(FranquiciaService service) {
        this.service = service;
    }

    @PostMapping
    public Franquicia crear(@RequestBody Franquicia f) {
        return service.crear(f);
    }

    @GetMapping("/{id}/top-productos")
    public List<TopProductoDTO> top(@PathVariable Long id) {
        return service.topProductos(id);
    }

    @PutMapping("/{id}/nombre")
    public Franquicia actualizarNombre(@PathVariable Long id,
            @RequestParam String nombre) {
        return service.actualizarNombre(id, nombre);
    }
}