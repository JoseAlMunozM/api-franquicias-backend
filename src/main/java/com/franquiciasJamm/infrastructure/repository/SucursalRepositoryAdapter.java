package com.franquiciasJamm.infrastructure.repository;

import com.franquiciasJamm.domain.model.Sucursal;
import com.franquiciasJamm.domain.repository.SucursalRepositoryPort;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SucursalRepositoryAdapter implements SucursalRepositoryPort {

    private final JpaSucursalRepository jpa;

    public SucursalRepositoryAdapter(JpaSucursalRepository jpa) {
        this.jpa = jpa;
    }

    public Sucursal save(Sucursal s) { return jpa.save(s); }
    public Optional<Sucursal> findById(Long id) { return jpa.findById(id); }
}