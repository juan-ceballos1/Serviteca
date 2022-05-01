package com.ceiba.tipoasistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearTipoAsistenciaTest {
    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del tipoServicio")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelTipoAsistencia() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().build();
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearTipoAsistencia servicioCrearTipoAsistencia = new ServicioCrearTipoAsistencia(repositorioTipoAsistencia);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearTipoAsistencia.ejecutar(tipoAsistencia), ExcepcionDuplicidad.class,"El tipo de servicio ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el tipoServicio de manera correcta")
    void deberiaCrearElTipoServicioDeManeraCorrecta() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().build();
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        Mockito.when(repositorioTipoAsistencia.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioTipoAsistencia.crear(tipoAsistencia)).thenReturn(10L);
        ServicioCrearTipoAsistencia servicioCrearTipoAsistencia = new ServicioCrearTipoAsistencia(repositorioTipoAsistencia);
        // act
        Long idTipoServicio = servicioCrearTipoAsistencia.ejecutar(tipoAsistencia);
        //- assert
        assertEquals(10L,idTipoServicio);
        Mockito.verify(repositorioTipoAsistencia, Mockito.times(1)).crear(tipoAsistencia);
    }
}
