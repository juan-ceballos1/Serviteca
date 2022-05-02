package com.ceiba.asistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoAsistencia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAsistenciaTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del la asistencia")
    void deberiaValidarLaExistenciaPreviaDeLaAsistencia() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conId(1L).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarAsistencia servicioActualizarAsistencia = new ServicioActualizarAsistencia(repositorioAsistencia);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAsistencia.ejecutar(asistencia), ExcepcionDuplicidad.class,"La asistencia no existe en el sistema");
    }
    @Test
    @DisplayName("Deberia eliminar la asistencia llamando al repositorio")
    void deberiaEliminarLaAsistenciaLlamandoAlRepositorio() {
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarAsistencia servicioEliminarAsistencia = new ServicioEliminarAsistencia(repositorioAsistencia);

        servicioEliminarAsistencia.ejecutar(1L);

        Mockito.verify(repositorioAsistencia, Mockito.times(1)).eliminar(1L);

    }
}
