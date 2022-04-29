package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;

public class ServicioEliminarAsistencia {
    private final RepositorioAsistencia repositorioAsistencia;

    public ServicioEliminarAsistencia(RepositorioAsistencia repositorioAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
    }

    public void ejecutar(Long id) {
        this.repositorioAsistencia.eliminar(id);
    }

}
