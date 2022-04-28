package com.ceiba.tiposervicio.servicio.testdatabuilder;

import com.ceiba.tiposervicio.comando.ComandoTipoServicio;

public class ComandoTipoServicioTestDataBuilder {

    private Long id;
    private String nombre;

    public ComandoTipoServicioTestDataBuilder() {
        nombre = "Arreglar";
    }

    public ComandoTipoServicioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoTipoServicio build() {
        return new ComandoTipoServicio(id,nombre);
    }

}
