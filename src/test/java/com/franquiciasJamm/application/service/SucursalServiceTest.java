package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.*;
import com.franquiciasJamm.domain.repository.*;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SucursalServiceTest {

    @Mock
    SucursalRepositoryPort sucursalRepo;

    @Mock
    FranquiciaRepositoryPort franquiciaRepo;

    @InjectMocks
    SucursalService service;

    public SucursalServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearSucursal() {

        Franquicia f = new Franquicia();
        f.setId(1L);

        Sucursal s = new Sucursal();
        s.setNombre("Centro");

        when(franquiciaRepo.findById(1L)).thenReturn(Optional.of(f));
        when(sucursalRepo.save(any())).thenReturn(s);

        Sucursal result = service.crear(1L, s);

        assertEquals("Centro", result.getNombre());
    }
}