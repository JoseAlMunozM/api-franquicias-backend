package com.franquiciasJamm.domain.repository;

import com.franquiciasJamm.domain.model.Sucursal;
import java.util.Optional;

public interface SucursalRepositoryPort {
    Sucursal save(Sucursal sucursal);
    Optional<Sucursal> findById(Long id);
}