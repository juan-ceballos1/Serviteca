package com.ceiba.tipoasistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;

public class ServicioCrearTipoAsistencia {

    private static final String EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El tipo de servicio ya existe en el sistema";
    private final RepositorioTipoAsistencia repositorioTipoAsistencia;

    public ServicioCrearTipoAsistencia(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        this.repositorioTipoAsistencia = repositorioTipoAsistencia;
    }

    public Long ejecutar(TipoAsistencia tipoAsistencia) {
        validarExistenciaPrevia(tipoAsistencia);
        return this.repositorioTipoAsistencia.crear(tipoAsistencia);
    }

    private void validarExistenciaPrevia(TipoAsistencia tipoAsistencia) {
        boolean existe = this.repositorioTipoAsistencia.existe(tipoAsistencia.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
