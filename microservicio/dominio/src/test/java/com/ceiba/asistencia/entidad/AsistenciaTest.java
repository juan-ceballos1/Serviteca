package com.ceiba.asistencia.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.servicio.testdatabuilder.AsistenciaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsistenciaTest {

    @Test
    @DisplayName("Deberia crear correctamente la asistencia")
    void deberiaCrearCorrectamenteLaAsistencia() {
        // arrange
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = LocalDateTime.now();
        //act
        Asistencia asistencia = new AsistenciaTestDataBuilder().conFechaInicio(fechaInicio).conFechaFin(fechaFin).build();
        //assert
        assertEquals(1, asistencia.getId());
        assertEquals(2, asistencia.getIdTipoAsistencia());
        assertEquals(3, asistencia.getIdVehiculo());
        assertEquals(fechaInicio, asistencia.getFechaInicio());
        assertEquals(fechaFin,asistencia.getFechaFin());
        assertEquals(2000,asistencia.getPrecio());
    }

    @Test
    void deberiaFallarSinIdTipoAsistencia() {

        //Arrange
        AsistenciaTestDataBuilder asistenciaTestDataBuilder = new AsistenciaTestDataBuilder().conIdTipoAsistencia(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    asistenciaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de servicio");
    }

    @Test
    void deberiaFallarSinIdVehiculo() {

        //Arrange
        AsistenciaTestDataBuilder asistenciaTestDataBuilder = new AsistenciaTestDataBuilder().conIdVehiculo(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    asistenciaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el vehiculo");
    }

    @Test
    void deberiaFallarSinFechaInicio() {

        //Arrange
        AsistenciaTestDataBuilder asistenciaTestDataBuilder = new AsistenciaTestDataBuilder().conFechaInicio(null);
        //act-assertExcepcionValorInvalido
        BasePrueba.assertThrows(() -> {
                    asistenciaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha inicio");
    }
    @Test
    void deberiaFallarSiPrecioMenorOIgulaACero() {

        //Arrange
        AsistenciaTestDataBuilder asistenciaTestDataBuilder = new AsistenciaTestDataBuilder().conPrecio((double) 0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    asistenciaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El precio debe ser mayor a 0");
    }

    @Test
    void deberiaFallarSiFechaInicialEsDomingo() {

        //Arrange
        AsistenciaTestDataBuilder asistenciaTestDataBuilder = new AsistenciaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2022-05-01T18:15:56.331372800"));
        //act-assert
        BasePrueba.assertThrows(() -> {
                    asistenciaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Los domingos no hay servicio");
    }
}
