package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;

public class ServicioCrearAsistencia {

    private final RepositorioAsistencia repositorioAsistencia;
    private final DaoTipoAsistencia daoTipoAsistencia;

    public ServicioCrearAsistencia(RepositorioAsistencia repositorioAsistencia, DaoTipoAsistencia daoTipoAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
        this.daoTipoAsistencia = daoTipoAsistencia;
    }

    public Long ejecutar(Asistencia asistencia) {
        DtoTipoAsistencia dtoTipoAsistencia = obtenerTipoServicio(asistencia.getIdTipoAsistencia());
        asistencia.asignarPrecio(dtoTipoAsistencia.getNombre());
        asistencia.validarFechaFin(dtoTipoAsistencia.getNombre());
       return this.repositorioAsistencia.crear(asistencia);
    }

    private DtoTipoAsistencia obtenerTipoServicio(Long idTipoServicio){

        return  daoTipoAsistencia.consultarPorId(idTipoServicio);

    }
}
