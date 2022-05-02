package com.ceiba.asistencia.sevicio.testdatabuilder;

import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.modelo.entidad.Asistencia;

import java.time.LocalDateTime;

public class ComandoAsistenciaTestDataBuilder {
    private Long id;
    private Long idTipoAsistencia;
    private Long idVehiculo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double precio;

    public ComandoAsistenciaTestDataBuilder(){
        this.id= 1L;
        this.idTipoAsistencia= 1L;
        this.idVehiculo= 1L;
        this.fechaInicio=LocalDateTime.now();
        this.fechaFin=LocalDateTime.now();
        this.precio=2000;
    }

    public ComandoAsistenciaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio){
        this.fechaInicio=fechaInicio;
        return this;
    }

    public ComandoAsistenciaTestDataBuilder conFechaFin(LocalDateTime fechaFin){
        this.fechaFin=fechaFin;
        return this;
    }

    public ComandoAsistenciaTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ComandoAsistenciaTestDataBuilder conIdVehiculo(Long idVehiculo){
        this.idVehiculo=idVehiculo;
        return this;
    }

    public ComandoAsistenciaTestDataBuilder conIdTipoAsistencia(Long idTipoAsistencia){
        this.idTipoAsistencia=idTipoAsistencia;
        return this;
    }

    public ComandoAsistenciaTestDataBuilder conPrecio(Double precio){
        this.precio=precio;
        return this;
    }

    public ComandoAsistencia build() {
        return new ComandoAsistencia(id,idTipoAsistencia,idVehiculo,fechaInicio,fechaFin,precio);
    }

}
