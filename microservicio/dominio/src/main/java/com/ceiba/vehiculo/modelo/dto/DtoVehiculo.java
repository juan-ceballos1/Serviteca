package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoVehiculo {
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

}
