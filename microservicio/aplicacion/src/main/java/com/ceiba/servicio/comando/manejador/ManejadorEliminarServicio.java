package com.ceiba.servicio.comando.manejador;

import com.ceiba.servicio.servicio.ServicioEliminarServicio;
import com.ceiba.tiposervicio.servicio.ServicioEliminarTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarServicio {
    private final ServicioEliminarServicio servicioEliminarServicio;

    public ManejadorEliminarServicio(ServicioEliminarServicio servicioEliminarServicio) {
        this.servicioEliminarServicio = servicioEliminarServicio;
    }

    public void ejecutar(Long idServicio) {
        this.servicioEliminarServicio.ejecutar(idServicio);
    }
}
