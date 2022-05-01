package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioCrearTipoAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioCrearTipoAsistencia servicioCrearTipoAsistencia;

    public ManejadorCrearTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioCrearTipoAsistencia servicioCrearTipoAsistencia) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioCrearTipoAsistencia = servicioCrearTipoAsistencia;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoAsistencia comandoTipoAsistencia) {
        TipoAsistencia tipoAsistencia = this.fabricaTipoServicio.crear(comandoTipoAsistencia);
        return new ComandoRespuesta<>(this.servicioCrearTipoAsistencia.ejecutar(tipoAsistencia));
    }
}
