package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarVehiculoTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del vehiculo")
    void deberiaValidarLaExistenciaPreviaDelVehiculo() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act
        servicioActualizarVehiculo.ejecutar(vehiculo);
        //assert
        Mockito.verify(repositorioVehiculo,Mockito.times(1)).actualizar(vehiculo);
    }
}
