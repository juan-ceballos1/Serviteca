package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTipoServicio {
    private final ServicioEliminarTipoServicio servicioEliminarTipoServicio;

    public ManejadorEliminarTipoServicio(ServicioEliminarTipoServicio servicioEliminarTipoServicio) {
        this.servicioEliminarTipoServicio = servicioEliminarTipoServicio;
    }

    public void ejecutar(Long idTipoServicio) {
        this.servicioEliminarTipoServicio.ejecutar(idTipoServicio);
    }
}
