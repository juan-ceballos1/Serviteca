package com.ceiba.tiposervicio.comando.manejador;

import com.ceiba.tiposervicio.servicio.ServicioEliminarTipoServicio;
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
