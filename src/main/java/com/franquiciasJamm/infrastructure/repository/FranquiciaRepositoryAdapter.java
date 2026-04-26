package com.franquiciasJamm.infrastructure.repository;

import com.franquiciasJamm.domain.model.Franquicia;
import com.franquiciasJamm.domain.repository.FranquiciaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FranquiciaRepositoryAdapter implements FranquiciaRepositoryPort {

    private final JpaFranquiciaRepository jpa;

    public FranquiciaRepositoryAdapter(JpaFranquiciaRepository jpa) {
        this.jpa = jpa;
    }

    public Franquicia save(Franquicia f) { return jpa.save(f); }
    public Optional<Franquicia> findById(Long id) { return jpa.findById(id); }
}