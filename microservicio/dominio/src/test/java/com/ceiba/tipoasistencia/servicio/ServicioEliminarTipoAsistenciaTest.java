package com.ceiba.tipoasistencia.servicio;

import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoAsistenciaTest {
    @Test
    @DisplayName("Deberia eliminar el tipoServicio llamando al repositorio")
    void deberiaEliminarElTipoAsistenciaLlamandoAlRepositorio() {
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        ServicioEliminarTipoAsistencia servicioEliminarTipoAsistencia = new ServicioEliminarTipoAsistencia(repositorioTipoAsistencia);

        servicioEliminarTipoAsistencia.ejecutar(1L);

        Mockito.verify(repositorioTipoAsistencia, Mockito.times(1)).eliminar(1L);

    }
}
