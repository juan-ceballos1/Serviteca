package com.ceiba.asistencia.modelo.dto;

import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAsistencia {
    private Long id;
    private DtoTipoAsistencia tipoAsistencia;
    private DtoVehiculo vehiculo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaFin;
    private double precio;
}
