package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarVehiculoTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del vehiculo")
    void deberiaValidarLaExistenciaPreviaDelVehiculo() {
        // arrange
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarVehiculo servicioEliminarVehiculo = new ServicioEliminarVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarVehiculo.ejecutar(Mockito.anyLong()), ExcepcionDuplicidad.class,"El vehiculo no existe en el sistema");
    }
    @Test
    @DisplayName("Deberia eliminar el vehiculo llamando al repositorio")
    void deberiaEliminarElVehiculoLlamandoAlRepositorio() {
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarVehiculo servicioEliminarVehiculo = new ServicioEliminarVehiculo(repositorioVehiculo);

        servicioEliminarVehiculo.ejecutar(1L);

        Mockito.verify(repositorioVehiculo, Mockito.times(1)).eliminar(1L);

    }
}
