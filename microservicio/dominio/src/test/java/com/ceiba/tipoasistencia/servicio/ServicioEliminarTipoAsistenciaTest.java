package com.ceiba.tipoasistencia.servicio;

import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoAsistenciaTest {
    @Test
    @DisplayName("Deberia eliminar el tipoServicio llamando al repositorio")
    void deberiaEliminarElTipoServicioLlamandoAlRepositorio() {
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        ServicioEliminarTipoServicio servicioEliminarTipoServicio = new ServicioEliminarTipoServicio(repositorioTipoServicio);

        servicioEliminarTipoServicio.ejecutar(1L);

        Mockito.verify(repositorioTipoServicio, Mockito.times(1)).eliminar(1L);

    }
}
