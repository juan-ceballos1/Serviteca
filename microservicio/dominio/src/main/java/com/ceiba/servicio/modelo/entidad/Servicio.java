package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Servicio {
    private Long id;
    private Long idTipoServicio;
    private Long idVehiculo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double precio;

    public Servicio(Long id, Long idTipoServicio, Long idVehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFin, double precio) {
        this.id = id;
        this.idTipoServicio = idTipoServicio;
        this.idVehiculo = idVehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }
}
