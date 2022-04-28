package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.fabrica.FabricaVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVehiculo {
    private final FabricaVehiculo fabricaVehiculo;
    private final ServicioCrearVehiculo servicioCrearVehiculo;

    public ManejadorCrearVehiculo(FabricaVehiculo fabricaVehiculo,ServicioCrearVehiculo servicioCrearVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioCrearVehiculo = servicioCrearVehiculo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comandoVehiculo) {
        Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
        return new ComandoRespuesta<>(this.servicioCrearVehiculo.ejecutar(vehiculo));
    }
}
