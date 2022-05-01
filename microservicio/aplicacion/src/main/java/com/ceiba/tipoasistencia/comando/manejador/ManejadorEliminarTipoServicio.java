package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTipoServicio {
    private final ServicioEliminarTipoAsistencia servicioEliminarTipoAsistencia;

    public ManejadorEliminarTipoServicio(ServicioEliminarTipoAsistencia servicioEliminarTipoAsistencia) {
        this.servicioEliminarTipoAsistencia = servicioEliminarTipoAsistencia;
    }

    public void ejecutar(Long idTipoServicio) {
        this.servicioEliminarTipoAsistencia.ejecutar(idTipoServicio);
    }
}
