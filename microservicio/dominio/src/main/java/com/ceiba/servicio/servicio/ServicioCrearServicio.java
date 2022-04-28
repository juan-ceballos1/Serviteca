package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

public class ServicioCrearServicio {
    private static final String EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El servicio ya existe en el sistema";
    private final RepositorioServicio repositorioServicio;

    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public Long ejecutar(Servicio servicio) {
        validarExistenciaPrevia(servicio);
       return this.repositorioServicio.crear(servicio);
    }

    private void validarExistenciaPrevia(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorId(servicio.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
