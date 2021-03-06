package com.ceiba.asistencia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearAsistenciaTest {



    @Test
    @DisplayName("Deberia Crear la asistencia de manera correcta y aumentar el precio si es lavado o cambio de aceite en los dias martes")
    void deberiaCrearLaAsistenciaDeManeraCorrectaYAumentarSiEsMartes() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-03T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"LAVADO"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2600.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }

    @Test
    @DisplayName("Deberia Crear la asistencia de manera correcta y aumentar el precio si es lavado o cambio de aceite en los dias viernes")
    void deberiaCrearLaAsistenciaDeManeraCorrectaYAumentarSiEsViernes() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-06T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"LAVADO"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2600.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando el tipo de asistencia es diferente a lavado o cambio de aceite y no se entra el valor de la fecha finalizacion")
    void deberiaLanzarUnaExepcionSiNoSeIngresaFechaFinYEsLavadoOCambioDeAceite() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-06T18:15:56.331372800")).conFechaFin(null).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionValorObligatorio.class,"Se debe ingresar la fecha de finalizacion");
    }


    @Test
    @DisplayName("Deberia crearse si no es lavado ni cambio de aceite y tiene fecha final")
    void deberiaCrearseCorrectamenteSiNoEsLavadoNiCambioDeAceite() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-02T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-08T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2000.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la fecha final es menor a la fecha inicial")
    void deberiaLanzarUnaExepcionSiLaFechaFinalEsMenorALaFechaInicial() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-06T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-05T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionValorInvalido.class,"La fecha de finalizacion no debe ser menor a la de inicio");
    }


    @Test
    @DisplayName("Deberia crearse si es lavado o cambio de aceite y no tiene fecha final")
    void deberiaCrearseCorrectamenteSiNoEsLavadoNiCambioDeAceiteSinFechaFin() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-02T18:15:56.331372800")).conFechaFin(null).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"LAVADO"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2000.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        assertEquals(asistencia.getFechaFin(),asistencia.getFechaInicio());
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }
}
