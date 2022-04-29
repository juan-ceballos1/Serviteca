package com.ceiba.tipoasistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearTipoAsistenciaTest {
    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del tipoServicio")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelTipoServicio() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearTipoServicio servicioCrearTipoServicio = new ServicioCrearTipoServicio(repositorioTipoServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearTipoServicio.ejecutar(tipoAsistencia), ExcepcionDuplicidad.class,"El tipo de servicio ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el tipoServicio de manera correcta")
    void deberiaCrearElTipoServicioDeManeraCorrecta() {
        // arrange
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioTipoServicio.crear(tipoAsistencia)).thenReturn(10L);
        ServicioCrearTipoServicio servicioCrearTipoServicio = new ServicioCrearTipoServicio(repositorioTipoServicio);
        // act
        Long idTipoServicio = servicioCrearTipoServicio.ejecutar(tipoAsistencia);
        //- assert
        assertEquals(10L,idTipoServicio);
        Mockito.verify(repositorioTipoServicio, Mockito.times(1)).crear(tipoAsistencia);
    }
}
