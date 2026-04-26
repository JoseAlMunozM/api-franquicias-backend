package com.franquiciasJamm.infrastructure.repository;

import com.franquiciasJamm.domain.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSucursalRepository extends JpaRepository<Sucursal, Long> {
}