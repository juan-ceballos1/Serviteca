package com.ceiba.tipoasistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;

public class ServicioActualizarTipoServicio {

    private static final String EL_TIPO_SERVICIO_NO_EXISTE_EN_EL_SISTEMA = "El tipo servicio no existe en el sistema";
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioActualizarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public void ejecutar(TipoAsistencia tipoAsistencia) {
        validarExistenciaPrevia(tipoAsistencia);
        this.repositorioTipoServicio.actualizar(tipoAsistencia);
    }

    private void validarExistenciaPrevia(TipoAsistencia tipoAsistencia) {
        boolean existe = this.repositorioTipoServicio.existePorId(tipoAsistencia.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
