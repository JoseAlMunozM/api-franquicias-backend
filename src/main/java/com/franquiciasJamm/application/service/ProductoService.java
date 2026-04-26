package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.Producto;
import com.franquiciasJamm.domain.model.Sucursal;
import com.franquiciasJamm.domain.repository.ProductoRepositoryPort;
import com.franquiciasJamm.domain.repository.SucursalRepositoryPort;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepositoryPort productoRepo;
    private final SucursalRepositoryPort sucursalRepo;

    public ProductoService(ProductoRepositoryPort productoRepo,
                           SucursalRepositoryPort sucursalRepo) {
        this.productoRepo = productoRepo;
        this.sucursalRepo = sucursalRepo;
    }

    public Producto crear(Long sucursalId, Producto producto) {

        Sucursal s = sucursalRepo.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        producto.setSucursal(s);

        return productoRepo.save(producto);
    }

    public void eliminar(Long id) {
        productoRepo.deleteById(id);
    }

    public Producto actualizarStock(Long id, Integer stock) {
        Producto p = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        p.setStock(stock);
        return productoRepo.save(p);
    }

    public Producto actualizarNombre(Long id, String nombre) {
        Producto p = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        p.setNombre(nombre);
        return productoRepo.save(p);
    }
}