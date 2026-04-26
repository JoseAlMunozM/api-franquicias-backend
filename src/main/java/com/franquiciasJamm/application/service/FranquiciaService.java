package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.*;
import com.franquiciasJamm.domain.repository.*;
import com.franquiciasJamm.application.dto.TopProductoDTO;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranquiciaService {

    private final FranquiciaRepositoryPort franquiciaRepo;

    public FranquiciaService(FranquiciaRepositoryPort franquiciaRepo) {
        this.franquiciaRepo = franquiciaRepo;
    }

    public Franquicia crear(Franquicia f) {
        return franquiciaRepo.save(f);
    }
    public Franquicia actualizarNombre(Long id, String nombre) {

    Franquicia f = franquiciaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

    f.setNombre(nombre);

    return franquiciaRepo.save(f);
}

    public List<TopProductoDTO> topProductos(Long id) {

        Franquicia f = franquiciaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));

        return f.getSucursales().stream()
                .map(s -> {
                    if (s.getProductos() == null || s.getProductos().isEmpty()) return null;

                    Producto top = s.getProductos()
                            .stream()
                            .max(Comparator.comparing(Producto::getStock))
                            .orElse(null);

                    return new TopProductoDTO(
                            s.getNombre(),
                            top.getNombre(),
                            top.getStock()
                    );
                })
                .filter(x -> x != null)
                .collect(Collectors.toList());
    }
}