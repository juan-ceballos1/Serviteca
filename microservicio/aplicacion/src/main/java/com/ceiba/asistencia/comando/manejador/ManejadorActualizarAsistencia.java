package com.ceiba.asistencia.comando.manejador;

import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.comando.fabrica.FabricaAsistencia;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.servicio.ServicioActualizarAsistencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAsistencia {
    private final FabricaAsistencia fabricaAsistencia;
    private final ServicioActualizarAsistencia servicioActualizarAsistencia;

    public ManejadorActualizarAsistencia(FabricaAsistencia fabricaAsistencia, ServicioActualizarAsistencia servicioActualizarAsistencia) {
        this.fabricaAsistencia = fabricaAsistencia;
        this.servicioActualizarAsistencia = servicioActualizarAsistencia;
    }


    public void ejecutar(ComandoAsistencia comandoAsistencia) {
        Asistencia asistencia = this.fabricaAsistencia.crear(comandoAsistencia);
        this.servicioActualizarAsistencia.ejecutar(asistencia);
    }
}
