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
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la asistencia")
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
    @DisplayName("Deberia lanzar una exepcion cuando el tipo asistencia no existe")
    void deberiaLanzarUnaExepcionCuandoElTipoAsistenciaNoExista() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-02T18:15:56.331372800")).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act-asserts
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionDuplicidad.class,"El tipo de asistencia no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la asistencia de manera correcta y aumentar el precio si es lavado o cambio de aceite en los dias martes")
    void deberiaCrearLaAsistenciaDeManeraCorrectaYAumentarSiEsMartes() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-03T18:15:56.331372800")).conPrecio(2000.0).build();
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
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"LAVADO"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2600.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando el tipo de asistenciaes diferente a lavado o cambio de aceite y no se entra el valor de la fecha finalizacion")
    void deberiaLanzarUnaExepcionSiNoSeIngresaFechaFinYEsLavadoOCambioDeAceite() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-06T18:15:56.331372800")).conFechaFin(null).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionValorObligatorio.class,"Se debe ingresar la fecha de finalizacion");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la fecha final es menor a la fecha inicial")
    void deberiaLanzarUnaExepcionSiLaFechaFinalEsMenorALaFechaInicial() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-06T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-05T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionValorInvalido.class,"La fecha de finalizacion no debe ser menor a la de inicio");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando la fecha inicial es domingo")
    void deberiaLanzarUnaExepcionSiLaFechaInicialEsDomingo() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-01T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-05T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearAsistencia.ejecutar(asistencia), ExcepcionValorInvalido.class,"Los domingos no hay servicio");
    }

    @Test
    @DisplayName("Deberia crearse si no es lavado ni cambio de aceite y tiene fecha final")
    void deberiaCrearseCorrectamenteSiNoEsLavadoNiCambioDeAceite() {
        // arrange
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-02T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-05T18:15:56.331372800")).conPrecio(2000.0).build();
        RepositorioAsistencia repositorioAsistencia = Mockito.mock(RepositorioAsistencia.class);
        RepositorioTipoAsistencia repositorioTipoAsistencia = Mockito.mock(RepositorioTipoAsistencia.class);
        DaoTipoAsistencia daoTipoAsistencia = Mockito.mock(DaoTipoAsistencia.class);
        Mockito.when(repositorioAsistencia.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAsistencia.crear(asistencia)).thenReturn(10L);
        Mockito.when(repositorioTipoAsistencia.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoTipoAsistencia.consultarPorId(Mockito.anyLong())).thenReturn(new DtoTipoAsistencia(1L,"REPARACION"));
        ServicioCrearAsistencia servicioCrearAsistencia = new ServicioCrearAsistencia(repositorioAsistencia,daoTipoAsistencia,repositorioTipoAsistencia);
        // act
        Long idAsistencia = servicioCrearAsistencia.ejecutar(asistencia);
        //- assert
        assertEquals(2000.0,asistencia.getPrecio());
        assertEquals(10L,idAsistencia);
        Mockito.verify(repositorioAsistencia, Mockito.times(1)).crear(asistencia);
    }
}
