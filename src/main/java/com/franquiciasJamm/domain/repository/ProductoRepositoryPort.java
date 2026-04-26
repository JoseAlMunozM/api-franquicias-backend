package com.franquiciasJamm.domain.repository;

import com.franquiciasJamm.domain.model.Producto;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    void deleteById(Long id);
}