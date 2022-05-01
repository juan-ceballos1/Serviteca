package com.ceiba.tipoasistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;

public class ServicioActualizarTipoAsistencia {

    private static final String EL_TIPO_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "El tipo asistencia no existe en el sistema";
    private final RepositorioTipoAsistencia repositorioTipoAsistencia;

    public ServicioActualizarTipoAsistencia(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        this.repositorioTipoAsistencia = repositorioTipoAsistencia;
    }

    public void ejecutar(TipoAsistencia tipoAsistencia) {
        validarExistenciaPrevia(tipoAsistencia);
        this.repositorioTipoAsistencia.actualizar(tipoAsistencia);
    }

    private void validarExistenciaPrevia(TipoAsistencia tipoAsistencia) {
        boolean existe = this.repositorioTipoAsistencia.existePorId(tipoAsistencia.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
