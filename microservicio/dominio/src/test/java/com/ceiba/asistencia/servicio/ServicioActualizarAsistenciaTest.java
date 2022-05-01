package com.ceiba.asistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import org.mockito.Mockito;

public class ServicioActualizarAsistenciaTest {
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
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conId(1L).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarAsistencia servicioActualizarAsistencia = new ServicioActualizarAsistencia(repositorioAsistencia);
        // act
        servicioActualizarAsistencia.ejecutar(asistencia);
        //assert
        Mockito.verify(repositorioAsistencia,Mockito.times(1)).actualizar(asistencia);
    }
}
