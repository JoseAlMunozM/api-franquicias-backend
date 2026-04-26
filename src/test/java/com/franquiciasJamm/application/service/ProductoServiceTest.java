package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.*;
import com.franquiciasJamm.domain.repository.*;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceTest {

    @Mock
    ProductoRepositoryPort productoRepo;

    @Mock
    SucursalRepositoryPort sucursalRepo;

    @InjectMocks
    ProductoService service;

    public ProductoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearProducto() {

        Sucursal s = new Sucursal();
        s.setId(1L);

        Producto p = new Producto();
        p.setNombre("Mouse");

        when(sucursalRepo.findById(1L)).thenReturn(Optional.of(s));
        when(productoRepo.save(any())).thenReturn(p);

        Producto result = service.crear(1L, p);

        assertEquals("Mouse", result.getNombre());
    }

    @Test
    void actualizarStock() {

        Producto p = new Producto();
        p.setStock(5);

        when(productoRepo.findById(1L)).thenReturn(Optional.of(p));
        when(productoRepo.save(any())).thenReturn(p);

        Producto result = service.actualizarStock(1L, 50);

        assertEquals(50, result.getStock());
    }

    @Test
    void eliminarProducto() {

        doNothing().when(productoRepo).deleteById(1L);

        service.eliminar(1L);

        verify(productoRepo).deleteById(1L);
    }
}