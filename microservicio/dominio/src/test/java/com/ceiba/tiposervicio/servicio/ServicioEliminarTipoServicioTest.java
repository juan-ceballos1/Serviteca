package com.ceiba.tiposervicio.servicio;

import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoServicioTest {
    @Test
    @DisplayName("Deberia eliminar el tipoServicio llamando al repositorio")
    void deberiaEliminarElTipoServicioLlamandoAlRepositorio() {
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        ServicioEliminarTipoServicio servicioEliminarTipoServicio = new ServicioEliminarTipoServicio(repositorioTipoServicio);

        servicioEliminarTipoServicio.ejecutar(1L);

        Mockito.verify(repositorioTipoServicio, Mockito.times(1)).eliminar(1L);

    }
}
