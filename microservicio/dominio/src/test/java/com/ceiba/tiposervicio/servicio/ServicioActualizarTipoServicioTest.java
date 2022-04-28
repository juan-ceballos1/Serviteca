package com.ceiba.tiposervicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.TipoServicioTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarTipoServicioTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del tipo de servicio")
    void deberiaValidarLaExistenciaPreviaDelTipoDeServicio() {
        // arrange
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder().conId(1L).build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarTipoServicio servicioActualizarTipoServicio = new ServicioActualizarTipoServicio(repositorioTipoServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTipoServicio.ejecutar(tipoServicio), ExcepcionDuplicidad.class,"El tipoServicio no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder().conId(1L).build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarTipoServicio servicioActualizarTipoServicio = new ServicioActualizarTipoServicio(repositorioTipoServicio);
        // act
        servicioActualizarTipoServicio.ejecutar(tipoServicio);
        //assert
        Mockito.verify(repositorioTipoServicio,Mockito.times(1)).actualizar(tipoServicio);
    }
}
