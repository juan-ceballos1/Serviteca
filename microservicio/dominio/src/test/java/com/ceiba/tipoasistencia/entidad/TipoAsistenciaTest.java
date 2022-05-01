package com.ceiba.tipoasistencia.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoAsistenciaTest {
    @Test
    @DisplayName("Deberia crear correctamente el tipo asistencia")
    void deberiaCrearCorrectamenteElTipoServicio() {
        //act
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, tipoAsistencia.getId());
        assertEquals("arreglo", tipoAsistencia.getNombre());
    }

    @Test
    void deberiaFallarSinNombre() {

        //Arrange
        TipoAsistenciaTestDataBuilder tipoAsistenciaTestDataBuilder = new TipoAsistenciaTestDataBuilder().conNombre(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    tipoAsistenciaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "El nombre de la asistencia es obligatorio");
    }
}
