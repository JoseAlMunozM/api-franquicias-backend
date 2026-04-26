package com.franquiciasJamm.application.service;

import com.franquiciasJamm.domain.model.Franquicia;
import com.franquiciasJamm.domain.repository.FranquiciaRepositoryPort;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FranquiciaServiceTest {

    @Mock
    FranquiciaRepositoryPort repo;

    @InjectMocks
    FranquiciaService service;

    public FranquiciaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crear() {
        Franquicia f = new Franquicia();
        f.setNombre("Nike");

        when(repo.save(any())).thenReturn(f);

        Franquicia result = service.crear(f);

        assertEquals("Nike", result.getNombre());
    }

    @Test
    void actualizarNombre() {
        Franquicia f = new Franquicia();
        f.setNombre("Old");

        when(repo.findById(1L)).thenReturn(Optional.of(f));
        when(repo.save(any())).thenReturn(f);

        Franquicia result = service.actualizarNombre(1L, "New");

        assertEquals("New", result.getNombre());
    }
}
