package com.ceiba.tiposervicio.comando.manejador;

import com.ceiba.tiposervicio.comando.ComandoTipoServicio;
import com.ceiba.tiposervicio.comando.fabrica.FabricaTipoServicio;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.servicio.ServicioActualizarTipoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTipoServicio {
    private final FabricaTipoServicio fabricaTipoServicio;
    private final ServicioActualizarTipoServicio servicioActualizarTipoServicio;

    public ManejadorActualizarTipoServicio(FabricaTipoServicio fabricaTipoServicio, ServicioActualizarTipoServicio servicioActualizarTipoServicio) {
        this.fabricaTipoServicio = fabricaTipoServicio;
        this.servicioActualizarTipoServicio = servicioActualizarTipoServicio;
    }

    public void ejecutar(ComandoTipoServicio comandoTipoServicio) {
        TipoServicio tipoServicio = this.fabricaTipoServicio.crear(comandoTipoServicio);
        this.servicioActualizarTipoServicio.ejecutar(tipoServicio);
    }
}
