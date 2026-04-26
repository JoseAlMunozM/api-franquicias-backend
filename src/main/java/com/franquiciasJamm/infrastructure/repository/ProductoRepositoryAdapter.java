package com.franquiciasJamm.infrastructure.repository;


import org.springframework.stereotype.Repository;

import com.franquiciasJamm.domain.model.Producto;
import com.franquiciasJamm.domain.repository.ProductoRepositoryPort;

import java.util.Optional;

@Repository
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpa;

    public ProductoRepositoryAdapter(JpaProductoRepository jpa) {
        this.jpa = jpa;
    }

    public Producto save(Producto p) { return jpa.save(p); }
    public Optional<Producto> findById(Long id) { return jpa.findById(id); }
    public void deleteById(Long id) { jpa.deleteById(id); }
}