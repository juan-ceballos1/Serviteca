package com.ceiba.tiposervicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;

public class ServicioCrearTipoServicio {

    private static final String EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El tipo de servicio ya existe en el sistema";
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioCrearTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public Long ejecutar(TipoServicio tipoServicio) {
        validarExistenciaPrevia(tipoServicio);
        return this.repositorioTipoServicio.crear(tipoServicio);
    }

    private void validarExistenciaPrevia(TipoServicio tipoServicio) {
        boolean existe = this.repositorioTipoServicio.existe(tipoServicio.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
