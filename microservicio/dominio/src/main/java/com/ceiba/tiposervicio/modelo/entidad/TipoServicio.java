package com.ceiba.tiposervicio.modelo.entidad;

import lombok.Getter;

@Getter
public class TipoServicio {
    private Long id;
    private String nombre;
    public TipoServicio(Long id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
}
