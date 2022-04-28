package com.ceiba.servicio.comando.fabrica;

import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicio {
    public Servicio crear(ComandoServicio comandoServicio) {
        return new Servicio(
                comandoServicio.getId(),
                comandoServicio.getIdTipoServicio(),
                comandoServicio.getIdVehiculo(),
                comandoServicio.getFechaInicio(),
                comandoServicio.getFechaFin(),
                comandoServicio.getPrecio()
        );
    }
}
