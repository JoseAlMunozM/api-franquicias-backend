package com.franquiciasJamm.domain.repository;

import com.franquiciasJamm.domain.model.Franquicia;
import java.util.Optional;

public interface FranquiciaRepositoryPort {
    Franquicia save(Franquicia franquicia);
    Optional<Franquicia> findById(Long id);
}