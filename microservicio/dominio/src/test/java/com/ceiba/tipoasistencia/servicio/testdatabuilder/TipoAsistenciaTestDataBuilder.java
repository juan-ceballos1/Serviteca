package com.ceiba.tipoasistencia.servicio.testdatabuilder;

import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;

public class TipoAsistenciaTestDataBuilder {
    private Long id;
    private String nombre;

    public TipoAsistenciaTestDataBuilder() {
        nombre = "arreglo";
    }

    public TipoAsistenciaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoAsistenciaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TipoAsistencia build() {
        return new TipoAsistencia(id,nombre);
    }
}
