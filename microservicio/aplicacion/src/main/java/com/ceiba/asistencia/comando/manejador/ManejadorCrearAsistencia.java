package com.ceiba.asistencia.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.comando.fabrica.FabricaAsistencia;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.servicio.ServicioCrearAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAsistencia {
    private final FabricaAsistencia fabricaAsistencia;
    private final ServicioCrearAsistencia servicioCrearAsistencia;

    public ManejadorCrearAsistencia(FabricaAsistencia fabricaAsistencia, ServicioCrearAsistencia servicioCrearAsistencia) {
        this.fabricaAsistencia = fabricaAsistencia;
        this.servicioCrearAsistencia = servicioCrearAsistencia;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAsistencia comandoAsistencia) {
        Asistencia asistencia = this.fabricaAsistencia.crear(comandoAsistencia);
        return new ComandoRespuesta<>(this.servicioCrearAsistencia.ejecutar(asistencia));
    }
}
