package com.ceiba.tiposervicio.entidad;

import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.TipoServicioTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoServicioTest {
    @Test
    @DisplayName("Deberia crear correctamente el vehiculo")
    void deberiaCrearCorrectamenteElUsusuario() {
        //act
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, tipoServicio.getId());
        assertEquals("arreglo", tipoServicio.getNombre());
    }
}
