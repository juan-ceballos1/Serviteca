package com.ceiba.tiposervicio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tiposervicio.comando.ComandoTipoServicio;
import com.ceiba.tiposervicio.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.servicio.ServicioCrearTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioCrearTipoServicio servicioCrearTipoServicio;

    public ManejadorCrearTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioCrearTipoServicio servicioCrearTipoServicio) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioCrearTipoServicio = servicioCrearTipoServicio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoServicio comandoTipoServicio) {
        TipoServicio tipoServicio = this.fabricaTipoServicio.crear(comandoTipoServicio);
        return new ComandoRespuesta<>(this.servicioCrearTipoServicio.ejecutar(tipoServicio));
    }
}
