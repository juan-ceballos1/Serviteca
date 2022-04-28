package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

public class ServicioActualizarServicio {
    private static final String EL_SERVICIO_NO_EXISTE_EN_EL_SISTEMA = "El servicio no existe en el sistema";
    private final RepositorioServicio repositorioServicio;

    public ServicioActualizarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutar(Servicio servicio) {
        validarExistenciaPrevia(servicio);
        this.repositorioServicio.actualizar(servicio);
    }

    private void validarExistenciaPrevia(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorId(servicio.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_SERVICIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
