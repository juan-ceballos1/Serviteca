package com.ceiba.tipoasistencia.servicio;

import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;

public class ServicioEliminarTipoServicio {
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioEliminarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public void ejecutar(Long id) {
        this.repositorioTipoServicio.eliminar(id);
    }

}
