package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioActualizarTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioActualizarTipoServicio servicioActualizarTipoServicio;

    public ManejadorActualizarTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioActualizarTipoServicio servicioActualizarTipoServicio) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioActualizarTipoServicio = servicioActualizarTipoServicio;
    }

    public void ejecutar(ComandoTipoAsistencia comandoTipoAsistencia) {
        TipoAsistencia tipoAsistencia = this.fabricaTipoServicio.crear(comandoTipoAsistencia);
        this.servicioActualizarTipoServicio.ejecutar(tipoAsistencia);
    }
}
