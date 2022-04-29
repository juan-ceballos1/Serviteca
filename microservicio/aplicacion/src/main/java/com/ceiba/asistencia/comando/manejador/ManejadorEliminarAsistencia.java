package com.ceiba.asistencia.comando.manejador;

import com.ceiba.asistencia.servicio.ServicioEliminarAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAsistencia {
    private final ServicioEliminarAsistencia servicioEliminarAsistencia;

    public ManejadorEliminarAsistencia(ServicioEliminarAsistencia servicioEliminarAsistencia) {
        this.servicioEliminarAsistencia = servicioEliminarAsistencia;
    }

    public void ejecutar(Long idServicio) {
        this.servicioEliminarAsistencia.ejecutar(idServicio);
    }
}
