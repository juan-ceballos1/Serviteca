package com.ceiba.tipoasistencia.servicio.testdatabuilder;

import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;

public class ComandoTipoAsistenciaTestDataBuilder {

    private Long id;
    private String nombre;

    public ComandoTipoAsistenciaTestDataBuilder() {
        nombre = "Arreglar";
    }

    public ComandoTipoAsistenciaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoTipoAsistencia build() {
        return new ComandoTipoAsistencia(id,nombre);
    }

}
