package com.franquiciasJamm.infrastructure.repository;

import com.franquiciasJamm.domain.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFranquiciaRepository extends JpaRepository<Franquicia, Long> {
}