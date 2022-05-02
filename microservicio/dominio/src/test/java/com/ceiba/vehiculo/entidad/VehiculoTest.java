package com.ceiba.vehiculo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
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

    @Test
    void deberiaFallarSinMarca() {

        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMarca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la marca");
    }

    @Test
    void deberiaFallarSinModelo() {

        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conModelo(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el modelo");
    }

    @Test
    void deberiaFallarSinMatricula() {

        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMatricula(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la matricula");
    }

    @Test
    void deberiaFallarSiElTamanoEsMenorOIgualATres() {

        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMatricula("grs");
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La matricula debe tener una longitud mayor o igual a 4");
    }


}
