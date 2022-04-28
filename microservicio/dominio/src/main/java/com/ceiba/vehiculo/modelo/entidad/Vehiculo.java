package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

@Getter
public class Vehiculo {

    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(Long id,String matricula,String marca, String modelo){
        this.id = id;
        this.matricula= matricula;
        this.marca=marca;
        this.modelo=modelo;
    }
}
