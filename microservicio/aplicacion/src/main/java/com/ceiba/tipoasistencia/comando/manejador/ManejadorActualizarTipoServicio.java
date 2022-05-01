package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioActualizarTipoAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioActualizarTipoAsistencia servicioActualizarTipoAsistencia;

    public ManejadorActualizarTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioActualizarTipoAsistencia servicioActualizarTipoAsistencia) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioActualizarTipoAsistencia = servicioActualizarTipoAsistencia;
    }

    public void ejecutar(ComandoTipoAsistencia comandoTipoAsistencia) {
        TipoAsistencia tipoAsistencia = this.fabricaTipoServicio.crear(comandoTipoAsistencia);
        this.servicioActualizarTipoAsistencia.ejecutar(tipoAsistencia);
    }
}
