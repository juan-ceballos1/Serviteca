package com.ceiba.tipoasistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarTipoAsistenciaTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del tipo asistencia")
    void deberiaValidarLaExistenciaPreviaDelTipoAsistencia() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().conId(1L).build();
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarTipoAsistencia servicioActualizarTipoAsistencia = new ServicioActualizarTipoAsistencia(repositorioTipoAsistencia);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTipoAsistencia.ejecutar(tipoAsistencia), ExcepcionDuplicidad.class,"El tipo asistencia no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().conId(1L).build();
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarTipoAsistencia servicioActualizarTipoAsistencia = new ServicioActualizarTipoAsistencia(repositorioTipoAsistencia);
        // act
        servicioActualizarTipoAsistencia.ejecutar(tipoAsistencia);
        //assert
        Mockito.verify(repositorioTipoAsistencia,Mockito.times(1)).actualizar(tipoAsistencia);
    }
}
