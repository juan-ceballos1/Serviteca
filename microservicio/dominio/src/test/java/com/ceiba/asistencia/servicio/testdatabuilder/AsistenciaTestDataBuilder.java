package com.ceiba.asistencia.servicio.testdatabuilder;

import com.ceiba.asistencia.modelo.entidad.Asistencia;

import java.time.LocalDateTime;

public class AsistenciaTestDataBuilder {
    private Long id;
    private Long idTipoAsistencia;
    private Long idVehiculo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double precio;

    public AsistenciaTestDataBuilder(){
        this.id= Long.valueOf(1);
        this.idTipoAsistencia= Long.valueOf(2);
        this.idVehiculo= Long.valueOf(3);
        this.fechaInicio=LocalDateTime.now();
        this.fechaFin=LocalDateTime.now();
        this.precio=2000;
    }

    public AsistenciaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio){
        this.fechaInicio=fechaInicio;
        return this;
    }

    public AsistenciaTestDataBuilder conFechaFin(LocalDateTime fechaFin){
        this.fechaFin=fechaFin;
        return this;
    }

    public AsistenciaTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public AsistenciaTestDataBuilder conIdVehiculo(Long idVehiculo){
        this.idVehiculo=idVehiculo;
        return this;
    }

    public AsistenciaTestDataBuilder conIdTipoAsistencia(Long idTipoAsistencia){
        this.idTipoAsistencia=idTipoAsistencia;
        return this;
    }

    public AsistenciaTestDataBuilder conPrecio(Double precio){
        this.precio=precio;
        return this;
    }

    public Asistencia build() {
        return new Asistencia(id,idTipoAsistencia,idVehiculo,fechaInicio,fechaFin,precio);
    }
}
