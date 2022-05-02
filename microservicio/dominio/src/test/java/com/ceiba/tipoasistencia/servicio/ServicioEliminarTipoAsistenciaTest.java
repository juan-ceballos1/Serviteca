package com.ceiba.tipoasistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.servicio.ServicioEliminarAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoAsistenciaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del tipo asistencia")
    void deberiaValidarLaExistenciaPreviaDelTipoAsistencia() {
        // arrange
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarTipoAsistencia servicioEliminarTipoAsistencia = new ServicioEliminarTipoAsistencia(repositorioTipoAsistencia);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarTipoAsistencia.ejecutar(Mockito.anyLong()), ExcepcionDuplicidad.class,"El tipo asistencia no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia eliminar el tipoServicio llamando al repositorio")
    void deberiaEliminarElTipoAsistenciaLlamandoAlRepositorio() {
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarTipoAsistencia servicioEliminarTipoAsistencia = new ServicioEliminarTipoAsistencia(repositorioTipoAsistencia);

        servicioEliminarTipoAsistencia.ejecutar(1L);

        Mockito.verify(repositorioTipoAsistencia, Mockito.times(1)).eliminar(1L);

    }
}
