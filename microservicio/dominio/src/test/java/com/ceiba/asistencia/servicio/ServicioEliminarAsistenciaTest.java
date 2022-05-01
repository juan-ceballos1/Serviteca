package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoAsistencia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAsistenciaTest {
    @Test
    @DisplayName("Deberia eliminar la asistencia llamando al repositorio")
    void deberiaEliminarLaAsistenciaLlamandoAlRepositorio() {
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        ServicioEliminarAsistencia servicioEliminarAsistencia = new ServicioEliminarAsistencia(repositorioAsistencia);

        servicioEliminarAsistencia.ejecutar(1L);

        Mockito.verify(repositorioAsistencia, Mockito.times(1)).eliminar(1L);

    }
}
