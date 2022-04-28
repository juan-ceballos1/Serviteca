package com.ceiba.tiposervicio.servicio.testdatabuilder;

import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;

public class TipoServicioTestDataBuilder {
    private Long id;
    private String nombre;

    public TipoServicioTestDataBuilder() {
        nombre = "arreglo";
    }

    public TipoServicioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoServicioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TipoServicio build() {
        return new TipoServicio(id,nombre);
    }
}
