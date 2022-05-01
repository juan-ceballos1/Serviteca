package com.ceiba.asistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioCrearTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearAsistenciaTest {
    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del tipoServicio")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaAsistencia() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionDuplicidad.class,"La asistencia ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la asistencia de manera correcta")
    void deberiaCrearLaAsistenciaDeManeraCorrecta() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-02T18:15:56.331372800")).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"LAVADO"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }
}
