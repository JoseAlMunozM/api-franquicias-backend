package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.Franquicia;
import com.franquiciasJamm.domain.model.Sucursal;
import com.franquiciasJamm.domain.repository.FranquiciaRepositoryPort;
import com.franquiciasJamm.domain.repository.SucursalRepositoryPort;

import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    private final SucursalRepositoryPort sucursalRepo;
    private final FranquiciaRepositoryPort franquiciaRepo;

    public SucursalService(SucursalRepositoryPort sucursalRepo,
                           FranquiciaRepositoryPort franquiciaRepo) {
        this.sucursalRepo = sucursalRepo;
        this.franquiciaRepo = franquiciaRepo;
    }

    public Sucursal crear(Long franquiciaId, Sucursal sucursal) {

        Franquicia f = franquiciaRepo.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        sucursal.setFranquicia(f);

        return sucursalRepo.save(sucursal);
    }

    public Sucursal actualizarNombre(Long id, String nombre) {
        Sucursal s = sucursalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        s.setNombre(nombre);
        return sucursalRepo.save(s);
    }
}