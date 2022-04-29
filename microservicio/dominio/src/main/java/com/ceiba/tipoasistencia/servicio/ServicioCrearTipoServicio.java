package com.ceiba.tipoasistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;

public class ServicioCrearTipoServicio {

    private static final String EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El tipo de servicio ya existe en el sistema";
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioCrearTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public Long ejecutar(TipoAsistencia tipoAsistencia) {
        validarExistenciaPrevia(tipoAsistencia);
        return this.repositorioTipoServicio.crear(tipoAsistencia);
    }

    private void validarExistenciaPrevia(TipoAsistencia tipoAsistencia) {
        boolean existe = this.repositorioTipoServicio.existe(tipoAsistencia.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
