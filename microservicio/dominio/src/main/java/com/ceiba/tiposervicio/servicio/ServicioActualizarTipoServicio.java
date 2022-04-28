package com.ceiba.tiposervicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;

public class ServicioActualizarTipoServicio {

    private static final String EL_TIPO_SERVICIO_NO_EXISTE_EN_EL_SISTEMA = "El tipo servicio no existe en el sistema";
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioActualizarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public void ejecutar(TipoServicio tipoServicio) {
        validarExistenciaPrevia(tipoServicio);
        this.repositorioTipoServicio.actualizar(tipoServicio);
    }

    private void validarExistenciaPrevia(TipoServicio tipoServicio) {
        boolean existe = this.repositorioTipoServicio.existePorId(tipoServicio.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
