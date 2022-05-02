package com.ceiba.tipoasistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;

public class ServicioEliminarTipoAsistencia {

    private static final String EL_TIPO_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "El tipo asistencia no existe en el sistema";
    private final RepositorioTipoAsistencia repositorioTipoAsistencia;

    public ServicioEliminarTipoAsistencia(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        this.repositorioTipoAsistencia = repositorioTipoAsistencia;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioTipoAsistencia.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioTipoAsistencia.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
