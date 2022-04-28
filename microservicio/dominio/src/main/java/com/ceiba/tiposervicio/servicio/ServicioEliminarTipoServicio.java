package com.ceiba.tiposervicio.servicio;

import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;

public class ServicioEliminarTipoServicio {
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioEliminarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public void ejecutar(Long id) {
        this.repositorioTipoServicio.eliminar(id);
    }

}
