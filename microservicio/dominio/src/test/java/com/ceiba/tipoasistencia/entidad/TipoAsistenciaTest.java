package com.ceiba.tipoasistencia.entidad;

import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.TipoAsistenciaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoAsistenciaTest {
    @Test
    @DisplayName("Deberia crear correctamente el vehiculo")
    void deberiaCrearCorrectamenteElTipoServicio() {
        //act
        TipoAsistencia tipoAsistencia = new TipoAsistenciaTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, tipoAsistencia.getId());
        assertEquals("arreglo", tipoAsistencia.getNombre());
    }
}
