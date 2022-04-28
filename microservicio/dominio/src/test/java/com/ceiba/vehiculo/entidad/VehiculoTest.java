package com.ceiba.vehiculo.entidad;

import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    @DisplayName("Deberia crear correctamente el vehiculo")
    void deberiaCrearCorrectamenteElUsusuario() {
        //act
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, vehiculo.getId());
        assertEquals("1234", vehiculo.getMatricula());
        assertEquals("marca a",vehiculo.getMarca());
        assertEquals("centra", vehiculo.getModelo());
    }
}
