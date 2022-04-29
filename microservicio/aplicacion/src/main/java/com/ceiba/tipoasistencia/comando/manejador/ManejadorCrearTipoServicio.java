package com.ceiba.tipoasistencia.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioCrearTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioCrearTipoServicio servicioCrearTipoServicio;

    public ManejadorCrearTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioCrearTipoServicio servicioCrearTipoServicio) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioCrearTipoServicio = servicioCrearTipoServicio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoAsistencia comandoTipoAsistencia) {
        TipoAsistencia tipoAsistencia = this.fabricaTipoServicio.crear(comandoTipoAsistencia);
        return new ComandoRespuesta<>(this.servicioCrearTipoServicio.ejecutar(tipoAsistencia));
    }
}
