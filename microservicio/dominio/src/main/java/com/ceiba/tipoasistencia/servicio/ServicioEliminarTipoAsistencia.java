package com.ceiba.tipoasistencia.servicio;

import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;

public class ServicioEliminarTipoAsistencia {
    private final RepositorioTipoAsistencia repositorioTipoAsistencia;

    public ServicioEliminarTipoAsistencia(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        this.repositorioTipoAsistencia = repositorioTipoAsistencia;
    }

    public void ejecutar(Long id) {
        this.repositorioTipoAsistencia.eliminar(id);
    }

}
