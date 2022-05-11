package com.ceiba.asistencia.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAsistencia {
    private Long id;
    private Long idTipoAsistencia;
    private Long idVehiculo;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double precio;
}
