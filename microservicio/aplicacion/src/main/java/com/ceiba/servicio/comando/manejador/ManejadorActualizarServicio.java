package com.ceiba.servicio.comando.manejador;

import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.fabrica.FabricaServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.servicio.ServicioActualizarServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarServicio {
    private final FabricaServicio fabricaServicio;
    private final ServicioActualizarServicio servicioActualizarServicio;

    public ManejadorActualizarServicio(FabricaServicio fabricaServicio, ServicioActualizarServicio servicioActualizarServicio) {
        this.fabricaServicio = fabricaServicio;
        this.servicioActualizarServicio = servicioActualizarServicio;
    }


    public void ejecutar(ComandoServicio comandoServicio) {
        Servicio servicio = this.fabricaServicio.crear(comandoServicio);
        this.servicioActualizarServicio.ejecutar(servicio);
    }
}
